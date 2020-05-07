package com.hemagni.javaproject;

public class FlyingCar implements OperateCar, FlyCar {

    @Override
    public void startEngine(String key) {
        OperateCar.super.startEngine(key);
        FlyCar.super.startEngine(key);
    }
    public static void main(String[] args) {
        
        FlyingCar myFlyingCar = new FlyingCar();
        myFlyingCar.startEngine("BMW");
     
    }
    
}
