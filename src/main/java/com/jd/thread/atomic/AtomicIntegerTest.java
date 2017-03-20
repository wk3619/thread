package com.jd.thread.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;


public class AtomicIntegerTest {
    
	
	private static int threadCount = 10;
	private static CountDownLatch countDown = new CountDownLatch(threadCount);
	private static AtomicInteger count = new AtomicInteger(0);// 原子操作类

	private static class Counter implements Runnable {
		public void run() {
			for (int i = 0; i < 100; i++) {
				count.addAndGet(1);
			}
			countDown.countDown();
		}
	}
	public static void main(String[] args) throws InterruptedException { 
		Thread[] threads=new Thread[threadCount];  
	    for(int i=0;i<threadCount;i++){  
	        threads[i]=new Thread(new Counter());  
	    }  
	    for(int i=0;i<threadCount;i++){  
	        threads[i].start();;  
	    }  
	    countDown.await();  
	    System.out.println(count.get()); 
	}
	
}


















