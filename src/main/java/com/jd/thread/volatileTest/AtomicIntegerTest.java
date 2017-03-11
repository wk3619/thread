package com.jd.thread.volatileTest;

import java.util.concurrent.atomic.AtomicInteger;



/**
 * 借助LinkedBlockingQueue来实现生产者消费者模式
 * @author gongbinglai
 *
 */
public class AtomicIntegerTest {
    

	public  static AtomicInteger count = new AtomicInteger();
	
	
	public static void inc() {
		
		System.out.println(Thread.currentThread().getName()+"对应的count值为:"+count.get());
		
		try{
			
			Thread.sleep(100);
			
			count.incrementAndGet();
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"count++后对应的count值为:"+count.get());
		
	}
	
	
    public static void main(String args[]){
    	
    	for(int i = 0; i < 1000; i++) {
    		new Thread(new Runnable() {
	    		public void run() {
	    			AtomicIntegerTest.inc();
	    		}
    		}).start();
    	}
    }
    
}



