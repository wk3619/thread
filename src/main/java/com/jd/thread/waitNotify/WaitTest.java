package com.jd.thread.waitNotify;



public class WaitTest {
    
	
	public static void main(String[] args){

		WaitService service = new WaitService();
		
		WaitThread t1 = new WaitThread(service);
		WaitThread t2 = new WaitThread(service);
		
		t1.start();
		t2.start();
    }
	
}


class WaitService{
	
	private int count = 0 ;
	
	public void print(){
		System.out.println("============="+(++count));
	}
}

class WaitThread extends Thread{

	private WaitService service;
	
    public WaitThread(WaitService service) {
       this.service = service;
    }

    
    
    public void run() {
        synchronized (service) {
            
        	for(int i=0;i<100;i++){
        		
        		if(i==10){
        			try {
        				
        				//先唤醒一个线程，然后再让当前线程等待service对象锁
        				service.notify();
						service.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
        		}
        		System.out.print(Thread.currentThread().getName()+"执行：");
        		service.print();
        	}
        	
        
        }
    }
}


