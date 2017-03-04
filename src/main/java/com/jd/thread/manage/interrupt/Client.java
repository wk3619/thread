package com.jd.thread.manage.interrupt;

public class Client {
    public static void main(String[] args) {

        
    	MutliThreadRunnable r = new MutliThreadRunnable("mythread");
    	Thread t = new Thread(r);
    	t.start();
    	
    	try{
    		t.sleep(5000);
    	}catch(InterruptedException e){
    		System.out.println("mythread线程被中断了");
    	}
    	
    	t.interrupt();
    	
    }
}
