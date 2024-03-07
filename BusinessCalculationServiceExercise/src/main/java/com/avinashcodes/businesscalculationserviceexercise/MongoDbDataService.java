package com.avinashcodes.businesscalculationserviceexercise;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDbDataService implements DataService{

    @Override
    public int[] retrivveData() {
        return new int[] {18,22,93,44,55};
    }


}
