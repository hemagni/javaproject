package com.hemagni.javaproject;

public class MountainBike extends Bicycle {

    public int seatHeight;
    
    public MountainBike() {
        
    }
    public MountainBike(int startCadence, int startGear, int startSpeed, int startHeight) {
        super(startCadence, startGear, startSpeed);
        seatHeight = startHeight;
    }
    
    public void setHeight(int newHeight) {
        seatHeight = newHeight;
    }
    
    @Override
    public void printBikeDetails() {
        super.printBikeDetails();
        System.out.format("Seat Height: %d %n",seatHeight);
    }
    
    
    public static void main(String[] args) {
        Bicycle myBike = new Bicycle(10,1,10);
        Bicycle obj = new MountainBike(20,2,20,50);
        MountainBike mBike;
        if(obj instanceof MountainBike)
            mBike = (MountainBike)obj;
        else
            mBike= null;
        myBike.printBikeDetails();
        mBike.printBikeDetails();
        
        
    }
}
