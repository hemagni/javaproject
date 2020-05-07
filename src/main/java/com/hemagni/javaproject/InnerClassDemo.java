package com.hemagni.javaproject;

public class InnerClassDemo {

    //Create an array
    private final static int SIZE = 15;
    private final int[] arrayOfInts = new int[SIZE];
    
    public InnerClassDemo() 
    {
        for(int i = 0; i<SIZE; i++) 
        {
            arrayOfInts[i] = i;
        }
    }
    
    public void printEven() 
    {
       DataStructureIterator iterator = this.new EvenIterator();
       while(iterator.hasNext()) {
           System.out.format("%d ",iterator.next());
       }
        System.out.println();
    }
    
    interface DataStructureIterator extends java.util.Iterator<Integer> {}
    
    private class EvenIterator implements DataStructureIterator {

        private int nextIndex = 0;
        
        @Override
        public boolean hasNext() {
 
            return(nextIndex<=SIZE-1);
        }

        @Override
        public Integer next() {
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
            nextIndex += 2;
            return retValue;
        }
        
    }
    
    public static void main(String[] args) {
        
        InnerClassDemo ds = new InnerClassDemo();
        ds.printEven();
    }
}
