package com.avinashcodes.businesscalculationserviceexercise;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan  // No need to mention the full package name because
// when we don't mention anything here then it automatically scans the current package.
public class AppLauncher {

    public static void main(String[] args) {


        try(var ctxt = new AnnotationConfigApplicationContext(AppLauncher.class)){

            System.out.println(ctxt.getBean(BusinessCalculationService.class).findMax());

        }

    }

}
