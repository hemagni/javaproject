package com.hemagni.javaproject;

import java.time.LocalDateTime;

public class Demo1 implements AnotherTimeClient {

    private LocalDateTime dateAndTime; 
    
    public Demo1() {
        dateAndTime = LocalDateTime.now();
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return dateAndTime;
    }
    
    public static void main(String[] args) {
        AnotherTimeClient myAnotherTimeClient = new Demo1();
        System.out.println("Zoned Date and Time: "+ myAnotherTimeClient.getZonedDateTime("UTC+05:00"));
    }
}
