package com.jd.thread.blockingQueue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class DelayQueueTest {
    

    public static void main(String args[]){
    	
    	CountDownLatch doneSingal = new CountDownLatch(2);
    	
    	Thread t1  = new Thread(new CountDownLatchThread(doneSingal) );
    	Thread t2  = new Thread(new CountDownLatchThread(doneSingal) );
    	
    	t1.start();
    	t2.start();
    	
    	
    	try {
			//doneSingal.await();
    		doneSingal.await(10,TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    	 System.out.println("main end");    
    }
    
}


class CountDownLatchThread implements Runnable {     
    
    private CountDownLatch doneSingal;     
    
    public CountDownLatchThread(CountDownLatch doneSingal) {     
        this.doneSingal = doneSingal;   
   }     
    
    public void run() {     
        try {     
             
        	 Thread.sleep((long)(Math.random()*1000));//模拟跑步需要的时间        
             
        	 System.out.println(Thread.currentThread().getName()+" end");
        	 
         } catch (InterruptedException e) {     
             e.printStackTrace();     
         } finally {     
        	 doneSingal.countDown();//向评委报告跑到终点了     
         }     
     }     
}    















