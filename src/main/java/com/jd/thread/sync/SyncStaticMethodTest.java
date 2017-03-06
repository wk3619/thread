package com.jd.thread.sync;


/**
 * 同步普通方法
 * @author gongbinglai
 *
 */
public class SyncStaticMethodTest {
    
	
	public static void main(String[] args){

		Thread  threadA = new SyncStaticMethodThread(new SyncStaticMethodService());
		Thread  threadB = new SyncStaticMethodThread(new SyncStaticMethodService());
		    
	    //线程A，线程B都需要获取类SyncStaticMethodService的锁，所以线程B需要等待线程A执行完再执行
	    threadA.start();
	    threadB.start();
		    
    }
	

}

class SyncStaticMethodService{
    static long count = 0;

    public static synchronized void add(long value){
      
    	count += value;
    	System.out.println("线程"+Thread.currentThread().getId()+"执行add方法,count值："+count);
    }
    
 }


class SyncStaticMethodThread extends Thread{

    protected SyncStaticMethodService counter = null;

    public SyncStaticMethodThread(SyncStaticMethodService counter){
       this.counter = counter;
    }

    public void run() {
    	for(int i=0; i<100; i++){
          counter.add(i);
       }
    }
 }


class SyncStaticMethodThread2 extends Thread{


    public SyncStaticMethodThread2(){
       
    }

    public void run() {
    	
    	SyncStaticMethodService service = new SyncStaticMethodService();
    	System.out.println("线程"+Thread.currentThread().getId()+"创建了SyncStaticMethodService");
    	
    }
 }





