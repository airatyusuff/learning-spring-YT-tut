package com.tutorial.game;

import components.GameRunner;
import components.GamingConsole;
import learning_spring.AppConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class GameApplicationSpring {

	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext(GameConfiguration.class)) {

			context.getBean(GamingConsole.class).up();

			context.getBean(GameRunner.class).run();
		}
	}

}
