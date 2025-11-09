package com.springweb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.springweb")
public class AppConfig {
//
//    @Bean
//    @Scope("prototype")
//    public HelloWorld helloWorld(){
//        System.out.println("Object create");
//        return new HelloWorld();
//    }
////    @Bean
////    public Bike bike(){
////        return new Bike();
////    }
//
//    @Bean
//   // @Qualifier
//    public Car car(){
//        return new Car();
//    }
}
