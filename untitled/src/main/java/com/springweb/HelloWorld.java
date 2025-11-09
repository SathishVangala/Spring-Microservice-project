package com.springweb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HelloWorld {
    private String name;
    @Autowired
    @Qualifier("car")
    private Vehicle veh;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVeh() {
        return veh;
    }

    public void setVeh(Vehicle veh) {
        this.veh = veh;
    }



  public void helloWorld(){
      System.out.println("Object is created in helloworld class.");
  }
 // @Qualifier("Bike")
  public void findVehicle(){
      System.out.println("this is find vehicle method");
      veh.typeofVeh();
  }

}
