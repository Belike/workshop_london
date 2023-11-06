package org.camunda.consulting.services;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomService {

    public int randomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public boolean randomBool(){
        return randomInt(0,1) == 0 ? false : true;
    }
}
