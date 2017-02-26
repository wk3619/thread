package com.jd.thread.manage;

public class MutliThread extends Thread{

	private int ticket=5;//每个线程都拥有100张票 
	 
	public MutliThread() {
	}

	public MutliThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		while (ticket > 0) {
			System.out.println(ticket-- + " is saled by "
					+ Thread.currentThread().getName());
		}
	}
}
