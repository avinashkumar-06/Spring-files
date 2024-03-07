package com.avinashcodes.annotaionbased.game;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.avinashcodes.annotaionbased")
public class AppGaming {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppGaming.class);

//        var game = context.getBean(GamingConsole.class);

//        System.out.println(game.getClass().getSimpleName());

        var runner = context.getBean(GameRunner.class);
        runner.run();


    }

}
