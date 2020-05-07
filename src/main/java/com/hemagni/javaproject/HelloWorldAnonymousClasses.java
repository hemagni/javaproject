package com.hemagni.javaproject;

public class HelloWorldAnonymousClasses 
{
    interface HelloWorld 
    {
        public void greet();
        public void greetSomeone(String someone);
    }
    
    public void sayHello()
    {
        class EnglishGreeting implements HelloWorld 
        {
            String name;
            
            @Override
            public void greet() 
            {
                greetSomeone("World");
            }

            @Override
            public void greetSomeone(String someone) 
            {
                name = someone;
                System.out.format("Hello %s%n",name);
            }
        }
        HelloWorld englishGreeting = new EnglishGreeting();
        englishGreeting.greet();
        englishGreeting.greetSomeone("Vijay");
        
        HelloWorld frenchGreeting = new HelloWorld() {
        
            String name;
            
            @Override
            public void greet() {
          
                greetSomeone("mundo");
            }

            @Override
            public void greetSomeone(String someone) {
                
                name = someone;
                System.out.format("Salut %s%n",someone);
            }
        };
        frenchGreeting.greetSomeone("Fred");
        
        
    }
    
    public static void main(String[] args) {
        
        HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }
}
