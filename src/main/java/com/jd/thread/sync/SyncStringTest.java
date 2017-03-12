package com.jd.thread.sync;


/**
 * 同步代码块测试
 * @author gongbinglai
 *
 */
public class SyncStringTest {
    
	
	public static void main(String[] args) throws InterruptedException{

		
		SyncStringService service = new SyncStringService();
		SyncStringThread t1 = new SyncStringThread(service);
		SyncStringThread t2 = new SyncStringThread(service);
		
		t1.setName("t1");
		t2.setName("t2");
		
		t1.start();
		
		
		//注意是让当前线程休眠1000ms，然后再启动t2，不是让t1睡眠
		Thread.sleep(1000);
		
		//如果不让当前线程休眠的话，那么t1 t2同时竞争123的对象锁，同步输出
		t2.start();
		
		
    }
	
}

class SyncStringService{

	private String lock = "123";
    
    public void methodA() {
    	
    	synchronized(lock){
    		
    		System.out.println("线程"+Thread.currentThread().getName()+" begin");
    		
    		
    		//此时lock对象发生了改变，线程t2同步需要获取的对象锁为456的锁
    		lock = "456";
    		
    		try {
				Thread.sleep(2000);
				
				System.out.println("线程"+Thread.currentThread().getName()+" end");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		
    		
    	}
    }
 }


class SyncStringThread extends Thread{

	private SyncStringService service;
	
	public SyncStringThread(SyncStringService service){
		this.service = service;
	}
	
	
    public void run() {
    	
    	service.methodA();
    }
 }


