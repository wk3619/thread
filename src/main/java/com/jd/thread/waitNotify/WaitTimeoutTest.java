package com.jd.thread.waitNotify;



public class WaitTimeoutTest {
    
	
	public static void main(String[] args){

		WaitTimeoutThread t1 = new WaitTimeoutThread("t1");
		
		//当前主线程获取t1对象锁
        synchronized(t1) {
            try {
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();

                // 主线程等待t1通过notify()唤醒 或 notifyAll()唤醒，或超过3000ms延时；然后才被唤醒。
                System.out.println(Thread.currentThread().getName() + " call wait ");
                t1.wait(3000);

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
	
}




class WaitTimeoutThread extends Thread{

	
    public WaitTimeoutThread(String name) {
    	super(name);
    }

    public void run() {
        
    	 System.out.println(Thread.currentThread().getName() + " run ");
         // 死循环，不断运行。
         while(true){
        	//System.out.println("===while true===="); 
         }
            
    	
    }
}


