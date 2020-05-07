/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemagni.javaproject;

/**
 *
 * @author root
 */
public class InterfaceDemo implements Relatable {
    private int len = 0;
    
    public InterfaceDemo(){};
    public InterfaceDemo(int l) {
        this.len = l;
    }
    
    @Override
    public int isGreaterThan(Relatable obj) {
        InterfaceDemo other = (InterfaceDemo) obj;
        if(this.len > other.len) {
            return 1;
        } else if(this.len < other.len) {
            return -1;
        } else {
            return 0;
        }
    }
    
    public  InterfaceDemo findGreater(InterfaceDemo obj1, InterfaceDemo obj2) {
      
        if(obj1.isGreaterThan(obj2)>0)
            return obj1;
        else
            return obj2;
    }
    
    
    public static void main(String[] args) {
        InterfaceDemo obj1 = new InterfaceDemo(800);
        InterfaceDemo obj2 = new InterfaceDemo(400);
        InterfaceDemo obj3 = new InterfaceDemo();
        obj3 = obj3.findGreater(obj1, obj2);
        int result = obj1.isGreaterThan(obj2);
        System.out.println("Result is: "+ obj3.len);
    }

    

    
}
