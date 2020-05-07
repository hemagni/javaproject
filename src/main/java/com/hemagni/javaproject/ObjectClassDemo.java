package com.hemagni.javaproject;

import java.util.Objects;

public class ObjectClassDemo implements Cloneable {

    private String name;
    
    public ObjectClassDemo() {
     
    }
    
    public ObjectClassDemo(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ObjectClassDemo) {
            return name.equals(((ObjectClassDemo)obj).name);
        } else return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
    public void printValues(ObjectClassDemo obj) {
        System.out.println(": "+obj.name.toString());
    }
    
    @Override
    public String toString() {
        String val = "Name: "+this.name;
        return val;
    }
    
    public static void main(String[] args) {
        ObjectClassDemo myObj = new ObjectClassDemo("Vijay Renu");
        ObjectClassDemo myObj2 = new ObjectClassDemo("Vijay Renu");
        myObj.printValues(myObj);
        System.out.println(" "+myObj.toString());
    }
}
