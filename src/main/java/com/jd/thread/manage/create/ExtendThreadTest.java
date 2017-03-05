package com.jd.thread.manage.create;

public class ExtendThreadTest {
    public static void main(String[] args) {

        //创建线程 
    	ExtendThread t1=new ExtendThread("Window 1"); 
    	ExtendThread t2=new ExtendThread("Window 2"); 
        
        t1.start(); 
        t2.start(); 

    }
}

 class ExtendThread extends Thread{

	private int ticket=3;//每个线程都拥有3张票 
	 
	public ExtendThread() {
	}

	public ExtendThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		while (ticket > 0) {
			System.out.println("票"+ticket-- + " is saled by 线程"+ Thread.currentThread().getName());
		}
	}
}

