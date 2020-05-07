package com.hemagni.javaproject;

public class Bicycle {

    private int cadence;
    private int gear;
    private int speed;
    
    public Bicycle() {
        
    }
    public Bicycle(int startCadence, int startGear, int startSpeed) {
        cadence = startCadence;
        gear = startGear;
        speed = startSpeed;
    }
    
    public void setCadence(int newCadence) {
        cadence = newCadence;
    }
    
    public void setGear(int newGear) {
        gear = newGear;
    }
    
    public void applyBreak(int decrement) {
        speed = speed - decrement;
    }
    
    public void speedUp(int increment) {
        speed = speed + increment;
    }
    
    public void printBikeDetails() {
        System.out.format("Cadence: %d Gear: %d Speed: %d %n",cadence, gear, speed);
    }
    
    public static void main(String[] args) {
        
        Bicycle obj = new Bicycle(1,1,10);
        obj.printBikeDetails();
        obj.setGear(2);
        obj.speedUp(10);
        obj.printBikeDetails();
        obj.setGear(1);
        obj.applyBreak(10);
        obj.printBikeDetails();
    }
}
