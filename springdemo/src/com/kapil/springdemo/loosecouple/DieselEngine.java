package com.kapil.springdemo.loosecouple;

public class DieselEngine implements IEngine{
    @Override
    public void start() {
        System.out.println("Petrol Engine Started");
    }
}
