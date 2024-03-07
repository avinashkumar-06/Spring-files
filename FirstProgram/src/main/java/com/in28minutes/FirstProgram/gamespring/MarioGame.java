package com.in28minutes.FirstProgram.gamespring;

public class MarioGame implements GamingConsole {

    public void up(){
        System.out.println("Jump");
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
