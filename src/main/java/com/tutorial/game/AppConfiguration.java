package com.tutorial.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address addr){}
record Address(String street, String city){}

@Configuration
public class AppConfiguration {

    @Bean({"getName"})
    public String name() {
        return "Airah";
    }

    @Bean
    public int age() {
        return 14;
    }

    @Bean
    public Person person() {
        return new Person("M3", 16, new Address("Close", "LDN"));
    }
    @Bean
    @Primary
    public Address address() {
        return new Address("Parrin Lane", "MCR");
    }
    @Bean
    public Address anotherAddress() {
        return new Address("PR Close", "LDN");
    }

    // can also use existing Beans
    @Bean
    public Person getAnotherPerson() {
        return new Person(name(), age(), address());
    }


    //if you don't match the specific bean name you want to use, it auto picks a matching Bean
    // (e.g. what it did with name despite the args being 'ame')
    //however, if there were two Beans for name, it runs into an UnsatisfiedDependencyException bc it doesn't know which to pick
    @Bean
    public Person getPersonWithExistingParams(String ame, int age, Address anotherAddress) {
        return new Person(ame, age, anotherAddress);
    }
}
