package com.avinashcodes.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorBasedDemo {
//
//    private Dependency1 dependency1;
//
//    private Dependency2 dependency2;
//
//    public ConstructorBasedDemo(@Autowired Dependency1 dependency1,
//                                @Autowired Dependency2 dependency2){
//
//        this.dependency1=dependency1;
//        this.dependency2=dependency2;
//
//
//    }
//
//    @Override
//    public String toString() {
//        return "ConstructorBasedDemo{" +
//                "dependency1=" + dependency1 +
//                ", dependency2=" + dependency2 +
//                '}';
//    }


    //  In constructor based dependency injection,
    //  we can ignore writing @Autowired
    //  because to create the bean for this class container will have to call the constructor
    //  ,and it will automatically inject the dependencies.
}
