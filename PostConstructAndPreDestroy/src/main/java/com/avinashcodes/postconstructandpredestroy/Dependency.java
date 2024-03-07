package com.avinashcodes.postconstructandpredestroy;


import org.springframework.stereotype.Component;

@Component
public class Dependency {


    public void dependencyMethod() {
        System.out.println("Dependency method called");
    }


}
