package com.avinashcodes.annotaionbased.game;


import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole {

    public void up(){
        System.out.println("Jump mario");
    }

    public void down(){
        System.out.println("Go into a hole");
    }

    public void left(){
        System.out.println("Go backward");
    }

    public void right(){
        System.out.println("Accelerate");
    }

}
