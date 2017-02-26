package com.jd.thread.manage;

public class MutliThreadDemo {
    public static void main(String[] args) {
        MutliThread m1=new MutliThread("Window 1"); 
        MutliThread m2=new MutliThread("Window 2"); 
        MutliThread m3=new MutliThread("Window 3"); 
//        m1.start();
//        m2.start();
//        m3.start();
        
        
        m1.run();
        m2.run();
        m3.run();
        
    }
}
