package com.hemagni.javaproject;

public interface OperateCar {
    
    default void startEngine(String key) {
        System.out.println("Operate Car Started " + key);
    }
    
}
