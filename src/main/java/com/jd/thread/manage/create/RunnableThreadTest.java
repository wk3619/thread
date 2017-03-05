package com.jd.thread.manage.create;

public class RunnableThreadTest {
    public static void main(String[] args) {

    	MutliThreadRunnable m1=new MutliThreadRunnable("Window 1"); 
        MutliThreadRunnable m2=new MutliThreadRunnable("Window 2"); 
        Thread t1=new Thread(m1); 
        Thread t2=new Thread(m2); 

//        t1.start(); 
//        t2.start(); 
        
        System.out.println("=====线程间资源共享=======");
        
        MutliThreadRunnable m3=new MutliThreadRunnable("Window 3"); 
        
        //此时线程3和线程4是共享线程对象的
        Thread t3=new Thread(m3); 
        Thread t4=new Thread(m3); 
        
        t3.start(); 
        t4.start(); 
    }
}

class MutliThreadRunnable implements  Runnable{

	private int ticket=3;//每个线程都拥有100张票 
	
	private String name; 
	
	public MutliThreadRunnable() {
	}
	
	
	public MutliThreadRunnable(String name){ 
	   this.name=name; 
	} 
	

	public void run() {
		while (ticket > 0) {
			System.out.println("票"+ticket-- + " is saled by 线程"+ this.name);
		}
	}
}
