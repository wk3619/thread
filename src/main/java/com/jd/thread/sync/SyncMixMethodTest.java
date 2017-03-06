package com.jd.thread.sync;


/**
 * 同步普通方法
 * @author gongbinglai
 *
 */
public class SyncMixMethodTest {
    
	
	public static void main(String[] args){

		
		SyncMixMethodService service = new SyncMixMethodService();
		
		
		Thread  threadA = new SyncMixMethodThread(service);
		Thread  threadB = new SyncMixMethodThread2(service);
		    
	    //线程A获取的为SyncMixMethodService类锁，而线程B需要获取的是service对象锁，所以相互独立
	    threadA.start();
	    threadB.start();
		    
    }
	

}

class SyncMixMethodService{
    static long count = 0;

    public static synchronized void add(long value){
      
    	count += value;
    	System.out.println("线程"+Thread.currentThread().getId()+"执行add方法,count值："+count);
    }
    
    public synchronized void print(){
        
    	System.out.println("线程"+Thread.currentThread().getId()+"执行print方法,count值："+count);
    }
    
 }


class SyncMixMethodThread extends Thread{

    protected SyncMixMethodService counter = null;

    public SyncMixMethodThread(SyncMixMethodService counter){
       this.counter = counter;
    }

    public void run() {
    	for(int i=0; i<10; i++){
          counter.add(i);
       }
    }
 }


class SyncMixMethodThread2 extends Thread{


    public SyncMixMethodThread2(){
       
    }

    protected SyncMixMethodService counter = null;

    public SyncMixMethodThread2(SyncMixMethodService counter){
       this.counter = counter;
    }

    public void run() {
    	
    	for(int i=0; i<10; i++){
    		counter.print();
        }
    	
    }
 }





