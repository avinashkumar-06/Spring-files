package com.avinashcodes.postconstructandpredestroy;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class DemoClass {

    private Dependency dependency;

    public DemoClass(Dependency dependency){
        this.dependency=dependency;
        System.out.println("Dependency injected");
    }


    // This bean will be created at application startup because of eager initialization and then
    //   dependency injection will happen. As soon dependenncy is injected the method which is annotated with
    //      @PostConstruct will be automatically called.

    @PostConstruct
    public void initialize(){
        dependency.dependencyMethod();
        System.out.println("post constructor called.");
    }


    public void normalMethod(){
        System.out.println("Normal method to be called  from context");
    }

    // This method will be called automatically just before the application context is closed and
    //    bean is destroyed.

    @PreDestroy //
    public void cleanup(){
        System.out.println("Cleaning up and closing all connections");
    }




}
