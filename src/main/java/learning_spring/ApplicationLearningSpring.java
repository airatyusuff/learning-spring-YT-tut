package learning_spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class ApplicationLearningSpring {

	public static void main(String[] args) {
		// this is the Spring Boot way of getting the Application context of the Spring framework
//		ApplicationContext ctx = SpringApplication.run(GameApplicationSpring.class);

		// the one below is the traditional Spring way: using a Spring configuration class to create a Spring context
		try(var context = new AnnotationConfigApplicationContext(AppConfiguration.class)) {
			System.out.println(context.getBean("getName"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("getAnotherPerson"));
			System.out.println(context.getBean("getPersonWithExistingParams"));

			//can use the Bean type instead too, rather than name
			System.out.println(context.getBean(Address.class));

			Arrays.stream(context.getBeanDefinitionNames())
					.forEach(bean -> System.out.println("Bean: " + bean));
		}
	}

}
