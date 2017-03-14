package com.jd.thread.concurrent.utils;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

	
	 public static void main(String args[]){
		 ExecutorService exec = Executors.newCachedThreadPool();  
	     
		 //当所有线程到达栅栏位置后，运行BarrierAction
		 final CyclicBarrier barrier= new CyclicBarrier(4, new Runnable(){
				 
				 public void run() {
					System.out.println("大家都到齐了，开始happy去"); 
				}  //run
		 });
	      
	     for(int i=0;i<4;i++){ 
	    	 
	    	 exec.execute(new CyclicBarrierThread(barrier));
	     }
	     
	     System.out.println("isBroken:"+barrier.isBroken()+",numberWaiting:"+barrier.getNumberWaiting()+",parties:"+barrier.getParties());
	     
	     exec.shutdown(); 
	     System.out.println("main end");
	 }
}


class CyclicBarrierThread implements Runnable{

	private CyclicBarrier cyclicBarrier;
	final Random random=new Random(); 
	
	public CyclicBarrierThread(CyclicBarrier cyclicBarrier){
		this.cyclicBarrier = cyclicBarrier;
	}
	
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+" run "); 
		try { 
            Thread.sleep(random.nextInt(1000)); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
        System.out.println(Thread.currentThread().getName()+"到了"); 
        try { 
        	cyclicBarrier.await();//等待其他哥们 
        	
        	//cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
        	
        	
        	 System.out.println(Thread.currentThread().getName()+" wait"); 
        	
        	
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } catch (BrokenBarrierException e) { 
            e.printStackTrace(); 
        } 
	}
	
}







