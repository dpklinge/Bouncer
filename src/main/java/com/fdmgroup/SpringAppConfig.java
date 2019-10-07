package com.fdmgroup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fdmgroup.basicgame.Game;

@Configuration
@ComponentScan
public class SpringAppConfig {
	
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);
		SpringAppConfig.context=context;
		context.getBean(Game.class).startGame();
	}
	public static ApplicationContext getContext(){
		return context;
	}

}
