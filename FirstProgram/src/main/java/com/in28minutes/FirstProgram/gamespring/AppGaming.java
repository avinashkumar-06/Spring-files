package com.in28minutes.FirstProgram.gamespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;





public class AppGaming {

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        // Getting bean by type
        var pacmanBeanBype = context.getBean(GamingConsole.class); //I am ablle to get this by just menntioning type because out of three bean of samme type in AppConfig class, one is primary
        pacmanBeanBype.up();

        System.out.println("-------------------------------------------------------------------");



        var pacman = context.getBean("pacmanGame", GamingConsole.class); //  When you are getting bean by name, you have to mention the type of bean (Name of class) as well
        System.out.println(pacman.getClass().getSimpleName());// Its printing PacmanGame.  its printing the name of class
        pacman.up();



        var mario = context.getBean("marioGame",GamingConsole.class);
        System.out.println(mario.getClass().getSimpleName()); // Its printing MarioGame. its printing the name of class
        mario.up();



        var contra = context.getBean("superContraGame",GamingConsole.class);
        System.out.println(contra.getClass().getSimpleName()); // Its printing SuperContra. its printing the name of class
        contra.up();




    }

}
