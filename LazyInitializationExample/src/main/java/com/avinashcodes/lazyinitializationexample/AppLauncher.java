package com.avinashcodes.lazyinitializationexample;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("com.avinashcodes.lazyinitializationexample")
public class AppLauncher {

    public static void main(String[] args) {

        try(var ctxt = new AnnotationConfigApplicationContext(AppLauncher.class)){



            ctxt.getBean(DependencyA.class);

            System.out.println(List.of(ctxt.getBeanDefinitionNames()));




        }


    }

}
