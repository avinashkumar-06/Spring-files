package com.avinashcodes.annotaionbased.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("contraGame")
public class SuperContra implements GamingConsole {

    public void up(){
        System.out.println("up");
    }

    public void down(){
        System.out.println("down");
    }

    public void left(){
        System.out.println("go back");
    }

    public void right(){
        System.out.println("shoot bullet");
    }
}
