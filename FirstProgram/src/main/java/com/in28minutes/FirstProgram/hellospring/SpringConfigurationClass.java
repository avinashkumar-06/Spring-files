package com.in28minutes.FirstProgram.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age){};

record Address(String city,String state){};

@Configuration
public class SpringConfigurationClass {

    @Bean
     public String name(){
         return "avinash";
     }

     @Bean
     public int age(){
        return 18;
     }

     @Bean
     public Person person(){

        return new Person("Akash",20);
     }

     @Bean
     public Address address(){
        return new Address("Bangalore","Karnataka");
     }

     @Bean
     public Dummy dummy(){
        return new Dummy(11,22);
     }

}
