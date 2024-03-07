package com.avinashcodes.businesscalculationserviceexercise;

import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
public class BusinessCalculationService {

   private DataService service;


   // Not using @Autowired because in constructor based injection spring does autowiring when creating the bean of this component automaticaly.
    public BusinessCalculationService(DataService service){
       this.service=service;
   }


    public int findMax(){
        return Arrays.stream(service.retrivveData()).max().orElse(0);
    }


}
