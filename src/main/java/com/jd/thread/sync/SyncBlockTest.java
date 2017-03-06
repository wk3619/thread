package com.jd.thread.sync;


/**
 * 同步代码块测试
 * @author gongbinglai
 *
 */
public class SyncBlockTest {
    
	
	public static void main(String[] args){

//		Integer count = new Integer(0);
//		
//	    Thread  threadA = new SyncBlockThread(count);
//	    Thread  threadB = new SyncBlockThread(count);
//	    
//	    //由于A和线程B的目标对象为两个对象，所以相互独立
//	    threadA.start();
//	    threadB.start(); 
		
		
		
		Thread  threadA = new SyncBlockThread2();
		Thread  threadB = new SyncStaticMethodThread(new SyncStaticMethodService());
	 
		/**
		 * 由于需要同步的对象不同，线程A，B交替执行，如果线程同步synchronized(SyncStaticMethodService.class)时线程B阻塞
		 */
		threadA.start();
		threadB.start(); 
		
    }
	
}

class SyncBlockThread extends Thread{

	private Integer count = 0;
	
	
	public SyncBlockThread(Integer count ){
		this.count = count;
	}
    
    public void run() {
    	
    	//不允许synchronized基本类型，如int long double
    	synchronized(count){
    		
    		for(int i=0;i<5;i++){
    			count = count+i;
    			System.out.println("线程"+Thread.currentThread().getId()+"执行,count值："+count);
    		}
    		
    		
    	}
    }
 }

class SyncBlockThread2 extends Thread{

    public void run() {
    	
    	System.out.println("=======this======"+this);
    	synchronized(this){
    	//synchronized(SyncStaticMethodService.class){
    		
    		for(int i=0;i<500;i++){
    			System.out.println("线程"+Thread.currentThread().getId()+"执行,count值："+i);
    		}
    		
    		
    	}
    }
 }


