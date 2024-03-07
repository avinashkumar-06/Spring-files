package com.avinashcodes.lazyinitializationexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class DependencyA {

public DependencyA(){
    System.out.println("DependencyA bean initialized");
}


}
