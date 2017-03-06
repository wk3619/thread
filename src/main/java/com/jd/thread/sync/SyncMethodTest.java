package com.jd.thread.sync;


/**
 * 同步普通方法
 * @author gongbinglai
 *
 */
public class SyncMethodTest {
    
	
	public static void main(String[] args){

//		InvokeSyncMethodService counter = new InvokeSyncMethodService();
//	    Thread  threadA = new InvokeSyncMethodThread(counter);
//	    Thread  threadB = new InvokeSyncMethodThread(counter);
//	    
//	    //线程A，线程B访问的都是同步方法，都需要获取counter对象的同步锁，此时线程B需要等待线程A执行完再执行
//	    threadA.start();
//	    threadB.start();
	    
	    
//		InvokeSyncMethodService counter = new InvokeSyncMethodService();
//	    Thread  threadA = new InvokeSyncMethodThread(counter);
//	    Thread  threadB = new InvokeCommonMethodThread(counter);
//	    
//	    //由于线程B执行的为非同步方法，所以不需要等待线程A执行完再执行
//	    threadA.start();
//	    threadB.start();
		
		
		
	    Thread  threadA = new InvokeSyncMethodThread(new InvokeSyncMethodService());
	    Thread  threadB = new InvokeSyncMethodThread(new InvokeSyncMethodService());
	    
	    //由于A和线程B的目标对象为两个对象，所以相互独立
	    threadA.start();
	    threadB.start();
	    
	    
		
		
	    
	    
    }
	
}


class InvokeSyncMethodService{
    long count = 0;

    public synchronized void add(long value){
      
    	this.count += value;
    	System.out.println("线程"+Thread.currentThread().getId()+"执行add方法,count值："+count);
    }
    
    public void print(){
        
    	System.out.println("线程"+Thread.currentThread().getId()+"执行print方法,count值,"+count);
    }
    
    
 }

class InvokeSyncMethodThread extends Thread{

    protected InvokeSyncMethodService counter = null;

    public InvokeSyncMethodThread(InvokeSyncMethodService counter){
       this.counter = counter;
    }

    public void run() {
    	for(int i=0; i<500; i++){
          counter.add(i);
       }
    }
 }

class InvokeCommonMethodThread extends Thread{

    protected InvokeSyncMethodService counter = null;

    public InvokeCommonMethodThread(InvokeSyncMethodService counter){
       this.counter = counter;
    }

    public void run() {
    	for(int i=0; i<5; i++){
          counter.print();
       }
    }
 }



