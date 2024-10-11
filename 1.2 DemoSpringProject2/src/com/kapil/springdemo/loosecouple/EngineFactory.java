package com.kapil.springdemo.loosecouple;

public class EngineFactory {

    public IEngine getInstance(String engineType) {
        if(engineType.equals("petrol")){
            return new PetrolEngine();
        } else if(engineType.equals("diesel")){
            return new DieselEngine();
        }
        return null;
    }
}
