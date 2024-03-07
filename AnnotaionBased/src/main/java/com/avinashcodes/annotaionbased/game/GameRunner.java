package com.avinashcodes.annotaionbased.game;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {


    private GamingConsole game;


    // I am using qualifier to specially inject bean of Contra class.
    // Instead of using @Qualifier I could have annotated Contra class with @Primary
    public GameRunner( @Qualifier("contraGame") GamingConsole game) {

        this.game=game;

    }

    public void run() {

        System.out.println("Running game "+game);
        game.up();
        game.down();
        game.left();
        game.right();

    }
}
