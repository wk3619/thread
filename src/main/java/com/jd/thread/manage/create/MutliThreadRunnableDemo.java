package com.jd.thread.manage.create;

public class MutliThreadRunnableDemo {
    public static void main(String[] args) {

        
        
        MutliThreadRunnable m1=new MutliThreadRunnable("Window 1"); 
        MutliThreadRunnable m2=new MutliThreadRunnable("Window 2"); 
        MutliThreadRunnable m3=new MutliThreadRunnable("Window 3"); 
//        Thread t1=new Thread(m1); 
//        Thread t2=new Thread(m2); 
//        Thread t3=new Thread(m3); 
//        t1.start(); 
//        t2.start(); 
//        t3.start(); 
        
        
        m1.run();
        m2.run();
        m3.run();
        
        
    }
}
