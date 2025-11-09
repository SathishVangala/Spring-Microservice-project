package com.springweb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Qualifier
@Component
@Primary
public class Bike implements Vehicle{


    @Override
    public void typeofVeh() {
        System.out.println("This is a Bike type ");
    }
}
