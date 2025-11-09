package com.springweb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld h1 = (HelloWorld) context.getBean("helloWorld");
        h1.setName("Sathish");
        System.out.println( h1.getName());
        System.out.println( "Hello World!" );
        h1.helloWorld();
        h1.findVehicle();


    }
}
