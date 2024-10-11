package com.kapil.springdemo.loosecouple;

public class CarDemo {
    public static void main(String[] args) {
        EngineFactory engineFactory = new EngineFactory();
        Car car = new Car(engineFactory.getInstance("petrol"));
//        Car car = new Car(new PetrolEngine());
        car.drive();
    }
}
