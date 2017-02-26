package com.jd.thread.manage;

public class MutliThreadRunnable implements  Runnable{

	private int ticket=5;//每个线程都拥有100张票 
	private String name; 
	
	public MutliThreadRunnable() {
	}
	
	
	public MutliThreadRunnable(String name){ 
	   this.name=name; 
	} 
	

	public void run() {
		while (ticket > 0) {
			System.out.println(ticket-- + " is saled by "
					+ this.name);
		}
	}
}
