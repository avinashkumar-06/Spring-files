package com.avinashcodes.annotaionbased.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole {

    public void up(){
        System.out.println("go up -pacman");
    }

    public void down(){
        System.out.println("go down");
    }

    public void left(){
        System.out.println("move left");
    }

    public void right(){
        System.out.println("move right");
    }

}
