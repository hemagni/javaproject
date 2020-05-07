package com.hemagni.javaproject;


public class Cat extends Animal {

    public static void testClassMethod() {
        System.out.println("The static method in Cat class");
    }
    
    @Override
    public void testInstanceMethod() {
        System.out.println("The Instance method in Cat class");
    }
    
    public static void main(String[] args) {
        
        Cat myCat = new Cat();
        Animal myAnimal = new Cat();
        myCat = (Cat)myAnimal;
        myCat.testInstanceMethod();
        
    }
}
