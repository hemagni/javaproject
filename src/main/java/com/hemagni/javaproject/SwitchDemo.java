package com.hemagni.javaproject;

public class SwitchDemo {

    public static int getMonthNumber(String month) {
        int monthNumber = 0;
        if(month==null) {
            return 0;
        }
        switch(month.toLowerCase()) {
            case "january": 
                monthNumber = 1;
                break;
            case "february":
                monthNumber = 2;
                break;
            default:
                monthNumber = 0;
        }
        return monthNumber;
    }
    
    public static void main(String[] args) {
        String monthName = "February";
        int monthNumber = SwitchDemo.getMonthNumber(monthName);
        if(monthNumber!=0) {
            System.out.format("Month Number of %s is %d",monthName,monthNumber);
        } else {
            System.err.println("Invalid month name");
        }
    }
}
