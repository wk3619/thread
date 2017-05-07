package com.jd.thread.lock.abstractQueueSync;

import java.util.concurrent.locks.Lock;



public class TwinsLockTest {
    

    public static void main(String args[]) throws Exception{
    	
    	 final Lock lock = new TwinsLock();
         class Worker extends Thread {
        	 
        	 public Worker(String name){
        		 super(name);
        	 }
        	 
             public void run(){
                 while (true){
                     lock.lock();
                     try{
                    	 Thread.sleep(1000);
                         System.out.println(Thread.currentThread().getName());
                         Thread.sleep(1000);
                     }catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
                         lock.unlock();
                     }
                 }
             }
         }
         
         for (int i=0;i<10;i++){
             Worker w = new Worker("t_"+i);
             w.start();
         }
    	
    }
    
}










