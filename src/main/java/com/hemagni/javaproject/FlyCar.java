package com.hemagni.javaproject;

public interface FlyCar {

    default void startEngine(String key) {
        System.out.println("Fly car started" + key);
    }
    
}
