package com.hemagni.javaproject;

public class ShadowTest {
    private int x;
    ShadowTest() {
        x = 10;
    }
    
    class FirstLevel {
        private int x =1;
        
        public void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = "+ShadowTest.this.x);
        }
    }
    
    public static void main(String[] args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel f1 = st.new FirstLevel();
        f1.methodInFirstLevel(23);
    }
}
