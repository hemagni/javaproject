package com.hemagni.javaproject;

import java.util.Scanner;

   

public class VariablesDemo {
   
    char[] copyFrom;
    char[] copyTo = {'R','E','N','U',' '};
    
    public VariablesDemo() {
        copyFrom = new char[11];
        copyFrom[0] = 'V';
        copyFrom[1]='I';
        copyFrom[2]='J';
        copyFrom[3]='A';
        copyFrom[4]='Y';
        copyFrom[5]=' ';
        copyFrom[6]='K';
        copyFrom[7]='U';
        copyFrom[8]='M';
        copyFrom[9]='A';
        copyFrom[10]='R';
        
    }
    
    
    
    public void printArray() {
        System.out.println("Copy From "+new String(copyFrom));
    }    
   

    public static void main(String[] args) {
        VariablesDemo myVariable = new VariablesDemo();
        myVariable.printArray();
        char[] newArray = java.util.Arrays.copyOfRange(myVariable.copyFrom, 0,5);
        System.out.println(" "+new String(newArray));
    }
}
