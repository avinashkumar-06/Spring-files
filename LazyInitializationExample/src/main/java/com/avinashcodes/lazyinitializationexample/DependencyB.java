package com.avinashcodes.lazyinitializationexample;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class DependencyB {

    public DependencyB(){
        System.out.println("DependencyB bean initialized");
    }


}
