package com.hemagni.javaproject;

public class VarArgsDemo {
    
    private int x,y;
    public VarArgsDemo() {
        this.x = 10;
        this.y = 20;
    }
    
    public VarArgsDemo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setValues(VarArgsDemo obj, int x, int y) {
        obj.x = x;
        obj.y = y;
        obj = new VarArgsDemo(50,50);
        obj.printValues();
    }
    
    public void printValues() {
        System.out.format("X = %d Y = %d %n",this.x, this.y);
    }
    
    public static void main(String[] args) {
        VarArgsDemo obj1 = new VarArgsDemo();
        obj1.printValues();
        obj1.setValues(obj1, 100, 200);
        obj1.printValues();
    }
}
