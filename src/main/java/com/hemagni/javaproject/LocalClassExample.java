package com.hemagni.javaproject;

public class LocalClassExample {

    static String regularExpression = "[^0-9]";
    
    private static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {
        
        int numberLength = 10;
        
        class PhoneNumber {
            
            String formattedPhoneNumber = null;
            
            PhoneNumber(String phoneNumber) {
                
                String currentNumber = phoneNumber.replaceAll(regularExpression, "");
                if(currentNumber.length() == numberLength) {
                    formattedPhoneNumber = currentNumber;
                } else {
                    formattedPhoneNumber = null;
                }
            }
            
            public String getNumber() {
                
                return formattedPhoneNumber;
            }
            
            public void printOriginalNumbers() {
                System.out.format("Origional numbers are : %s and %s%n", phoneNumber1, phoneNumber2);
            }
        }
        
        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);
        myNumber1.printOriginalNumbers();
        if(myNumber1.getNumber() == null) {
            System.out.println("First Number is in valid");
        } else {
            System.out.format("First Number is %s%n",myNumber1.getNumber());
        }
        if(myNumber2.getNumber() == null) {
            System.out.println("Second Number is in valid");
        } else {
            System.out.format("Second Number is %d%n",myNumber2.getNumber());
        }
    }
    
    public static void main(String[] args) {
        validatePhoneNumber("123-456-4890","456-7890");
        
    }
}
