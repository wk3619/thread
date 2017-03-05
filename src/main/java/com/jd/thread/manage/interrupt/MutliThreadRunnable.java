package com.jd.thread.manage.interrupt;

public class MutliThreadRunnable implements  Runnable{

	private String name; 
	
	public MutliThreadRunnable() {
	}
	
	
	public MutliThreadRunnable(String name){ 
	   this.name=name; 
	} 
	

	public void run() {
		
		int num =0 ;
		
		while (true) {
			
			//同Thread.currentThread().isInterrupted()
			if(Thread.interrupted()){
			//if(Thread.currentThread().isInterrupted()){
				System.out.println("线程中断了，不再执行while循环了");
				return;
			}else{
				System.out.println(++num+" is saled by "+ this.name);
			}
		}
		

	}
}
