package com.hemagni.javaproject;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.lang.CharSequence;

public class Demo2 implements AbstractZoneTimeClient {

    private int counter=0;
    @Override
    public ZonedDateTime getZonedDateTime(String zoneString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTime(int hour, int minute, int second) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDate(int day, int month, int year) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDateAndTime(int day, int month, int year, int hour, int minute, int second) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalDateTime getLocalDateTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getCounter() {
        counter++;
        return counter;
    }
    
    public static void main(String[] args) {
        Demo2 obj1 = new Demo2();
        Demo2 obj2 = new Demo2();
        obj1.getCounter();
        obj2.getCounter();
        System.out.println(" obj " + obj1.counter);
        System.out.println(" obj " + obj2.counter);
    }
}
