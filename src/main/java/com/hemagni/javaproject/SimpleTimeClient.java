package com.hemagni.javaproject;

import java.time.*;
import java.lang.*;
import java.util.*;

public class SimpleTimeClient implements TimeClient{
    
    private LocalDateTime dateAndTime;
    
    public SimpleTimeClient() {
        dateAndTime = LocalDateTime.now();
    }
    
    @Override
    public void setTime(int hour, int minute, int second) {
        LocalDate currentDate = LocalDate.from(dateAndTime);
        LocalTime timeToSet = LocalTime.of(hour, minute, second);
        dateAndTime = LocalDateTime.of(currentDate, timeToSet);
    }
    
   @Override
    public void setDate(int day, int month, int year) {
        LocalDate setDate = LocalDate.of(year, month, day);
        LocalTime currentTime = LocalTime.from(dateAndTime);
        dateAndTime = LocalDateTime.of(setDate, currentTime);
    }
    
    @Override
    public void setDateAndTime(int day, int month, int year, int hour, int minute, int second) {
        LocalDate setDate = LocalDate.of(year, month, day);
        LocalTime setTime = LocalTime.of(hour, minute, second);
        dateAndTime = LocalDateTime.of(setDate, setTime);
    }
    
    @Override
    public LocalDateTime getLocalDateTime() {
        return dateAndTime;
    }
    
    
    @Override
    public String toString() {
        return dateAndTime.toString();
    }
    
    public static void main(String[] args) {
        
        TimeClient myTimeClient = new SimpleTimeClient();   
        System.out.println("Zone Date and Time: "+myTimeClient.getZonedDateTime("bla bla").toString());
    }
}
