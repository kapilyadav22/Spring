package com.kapil.springdemo.loosecouple;

public class Car {
    IEngine engine;

    Car(IEngine engine) {
        this.engine = engine;
    }

    public void drive(){
      engine.start();

//        if(start>=1){
//            System.out.println("Engine Started");
//        } else {
//            System.out.println("Engine Stopped");
//        }
    }
}
