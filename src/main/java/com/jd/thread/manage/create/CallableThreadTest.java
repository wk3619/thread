package com.jd.thread.manage.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

    	CallableThread ctt = new CallableThread();  
        FutureTask<Integer> ft = new FutureTask<Integer>(ctt);  
        
        Thread t1 = new Thread(ft,"t1");
        t1.start();
        System.out.println("子线程的返回值："+ft.get());  
    }
}





class CallableThread implements Callable<Integer>  {

	public Integer call() throws Exception {
	
		int i = 0;  
        for(;i<100;i++){  
            System.out.println(Thread.currentThread().getName()+" "+i);  
        }  
        return i;  
		
	}  
  

 
  
}  



















