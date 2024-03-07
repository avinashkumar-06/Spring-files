package com.in28minutes.FirstProgram.gamespring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public GamingConsole pacmanGame(){
        return new PacmanGame();
    }

    @Bean
    public  GamingConsole marioGame(){
        return new MarioGame();
    }

    @Bean
    public GamingConsole superContraGame(){
        return new SuperContra();
    }


    @Bean
    public String name(){
        return "in28Minutes";
    }
    


}
