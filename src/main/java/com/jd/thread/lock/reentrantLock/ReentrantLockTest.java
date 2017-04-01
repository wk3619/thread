package com.jd.thread.lock.reentrantLock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class ReentrantLockTest {
    

    public static void main(String args[]) throws InterruptedException, ExecutionException{
    	
    	Lock  waiterLock = new ReentrantLock();
    	ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(4);
    	
    	for(int i=0;i<3;i++){
    		threadPoolExecutor.execute(new Restaurant(waiterLock,"r_"+i) );
    	}
    	for(int i=0;i<3;i++){
    		threadPoolExecutor.execute(new Guest(waiterLock,"g_"+i) );
    	}
    	
    	threadPoolExecutor.shutdown();
    }
}


/**
 * 饭店
 * @author gongbinglai
 *
 */
class  Restaurant implements Runnable{

	private Lock waiterLock;
	private String name ;
	
	public Restaurant(Lock waiterLock,String name){
		this.name = name;
		this.waiterLock = waiterLock;
	}
	
	
	public void run() {
		waiterLock.lock();
	    try {
	    	System.out.println("饭店获取到服务员的锁："+name);
	    	Thread.sleep(2000);
	    }catch (Exception e) {
			e.printStackTrace();
		} finally {
	    	
	    	System.out.println("饭店释放服务员的锁："+name);
	    	waiterLock.unlock();
	    }
	}
	
}


/**
 * 客人
 * @author gongbinglai
 *
 */
class  Guest implements Runnable{

	private Lock waiterLock;
	private String name;
	
	
	public Guest(Lock waiterLock,String name){
		this.name = name;
		this.waiterLock = waiterLock;
	}
	
	
	public void run() {
		
		waiterLock.lock();
	    try {
	    	System.out.println("客人获取到服务员的锁："+name);
			Thread.sleep(2000);
	    	
	    }catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
	    	
	    	System.out.println("客人释放服务员的锁："+name);
	    	waiterLock.unlock();
	    }
		
	}
	
}



