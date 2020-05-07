package com.hemagni.javaproject;

public class BranchingDemo {

    public static int findNofPs(String str) {
        int nofPs = 0;
        System.out.println("str "+str+str.length());
        if(str.length()==0 || str.equals(null)) {
            return 0;
        }
        System.out.println("I am here");
        int len = str.length();
        for(int i=0; i<len; i++) {
            if(str.charAt(i)=='p') {
                nofPs++;
            } else {
                continue;
            }
        }
        return nofPs;
    }
    
    public static void main(String[] args) {
     
        String searchInString = "peter piper picked a " + "peck of pickled peppers";
        try {
            int nofPs = BranchingDemo.findNofPs(searchInString);
            System.out.format("Nof 'P's %d", nofPs);
        } catch(NullPointerException npx) {
            System.out.format(" %s - String should not be null ",npx.toString());
        }
    }
}
