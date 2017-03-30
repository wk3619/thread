package com.jd.thread.waitNotify;



public class NotifyAllTest {
    
	
	public static void main(String[] args){

		
		Object obj = new Object();
		
		
		NotifyAllThread t1 = new NotifyAllThread("t1",obj);
		NotifyAllThread t2 = new NotifyAllThread("t2",obj);
		NotifyAllThread t3 = new NotifyAllThread("t3",obj);
        t1.start();
        t2.start();
        t3.start();

        try {
            System.out.println(Thread.currentThread().getName()+" sleep(3000)");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized(obj) {
            // 主线程等待唤醒。
            System.out.println(Thread.currentThread().getName()+" notifyAll()");
            obj.notifyAll();
        }
    }
	
	
}




class NotifyAllThread extends Thread{

	private Object obj;
	
    public NotifyAllThread(String name) {
    	super(name);
    }
    public NotifyAllThread(String name,Object obj) {
    	super(name);
    	this.obj = obj;
    }

    public void run() {
        
    	 synchronized (obj) {
             try {
                 // 打印输出结果
                 System.out.println(Thread.currentThread().getName() + " wait");

                 // 唤醒当前的wait线程
                 obj.wait();

                 // 打印输出结果
                 System.out.println(Thread.currentThread().getName() + " continue");
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    	
    }
}


