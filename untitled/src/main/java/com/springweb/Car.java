package com.springweb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class Car implements Vehicle {
    public void typeofVeh() {
        System.out.println("This is a Car type ");
    }
}
