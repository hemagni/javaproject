package com.hemagni.javaproject;

import java.util.function.Consumer;

public class LambdaScopeTest {

    public int x = 0;
    
    class FirstLevel {
        
        public int x = 1;
        
        public void methodFirstLevel(int x) {
            
            Consumer<Integer> myConsumer = (y)-> {
                System.out.println("x = "+x);
                System.out.println("y = "+y);
                System.out.println("this.x = "+this.x);
                System.out.println("LambdaScopeTest.this.x = "+ LambdaScopeTest.this.x);
            };
            myConsumer.accept(x);                
        }
    }
    
    public static void main(String[] args) {
        
        LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel f1 = st.new FirstLevel();
        f1.methodFirstLevel(23);
    }
}
