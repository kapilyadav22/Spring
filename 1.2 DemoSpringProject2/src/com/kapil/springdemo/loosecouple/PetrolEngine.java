package com.kapil.springdemo.loosecouple;

public class PetrolEngine implements IEngine {
    @Override
    public void start() {
        System.out.println("Petrol Engine Started");
    }
}
