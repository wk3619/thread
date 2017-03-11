package com.jd.thread.volatileTest;



/**
 * 借助LinkedBlockingQueue来实现生产者消费者模式
 * @author gongbinglai
 *
 */
public class VolatileAtomicTest {
    

	public volatile static int count = 0;
	
	
	public static void inc() {
		
		System.out.println(Thread.currentThread().getName()+"对应的count值为:"+count);
		
		try{
			
			Thread.sleep(100);
			
			count++;
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"count++后对应的count值为:"+count);
		
	}
	
	
    public static void main(String args[]){
    	
    	for(int i = 0; i < 1000; i++) {
    		new Thread(new Runnable() {
	    		public void run() {
	    			VolatileAtomicTest.inc();
	    		}
    		}).start();
    	}
    }
    
}



