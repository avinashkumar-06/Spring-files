package com.avinashcodes.beanscope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppLauncher {


    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(AppLauncher.class)){

            // For Singleton beans the same instance is returned every time
            // It means that the same object is returned every time when we call getBean() method
            System.out.println(context.getBean(SingletonClass.class));
            System.out.println(context.getBean(SingletonClass.class));
            System.out.println(context.getBean(SingletonClass.class));

            /*

            Output:

                    com.avinashcodes.beanscope.SingletonClass@2ceb80a1
                    com.avinashcodes.beanscope.SingletonClass@2ceb80a1
                    com.avinashcodes.beanscope.SingletonClass@2ceb80a1


             */




            // For Prototype beans a new instance is returned every time
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));


            /*

                Output:

                    com.avinashcodes.beanscope.PrototypeClass@2ceb80a1
                    com.avinashcodes.beanscope.PrototypeClass@1f7030a4
                    com.avinashcodes.beanscope.PrototypeClass@7e0babb1
                    com.avinashcodes.beanscope.PrototypeClass@5e2de80c


             */



        }
    }


}
