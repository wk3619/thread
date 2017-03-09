package com.jd.thread.threadLocal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * 借助LinkedBlockingQueue来实现生产者消费者模式
 * @author gongbinglai
 *
 */
public class ThreadLocalTest {
    

    public static void main(String args[]){
    	
    	ThreadLocalUtils tlt = new ThreadLocalUtils();
    	 
    	 ThreadLocalThread tt1 = new ThreadLocalThread(tlt);  
    	 ThreadLocalThread tt2 = new ThreadLocalThread(tlt);  
    	 ThreadLocalThread tt3 = new ThreadLocalThread(tlt);  
         
    	 Thread t1 = new Thread(tt1);  
         Thread t2 = new Thread(tt2);  
         Thread t3 = new Thread(tt3);  
         
         
         t1.start();  
         t2.start();  
         t3.start();  
    	
    }
    
}


class ThreadLocalUtils{
	
	private static final ThreadLocal<Integer> tlNum = new ThreadLocal<Integer>(){  
        protected Integer initialValue() {   
            return 10;  
        }  
    };  
    
    
    public static int getNextNum(){  
        Integer num = tlNum.get();
        tlNum.set(num+1);
        return tlNum.get();
    }  
      
}


class ThreadLocalThread implements Runnable{  
    
	private ThreadLocalUtils tlt;  
      
    public ThreadLocalThread(ThreadLocalUtils tlt) {  
        this.tlt = tlt;  
    }  
    public void run() {  
        int n = 3;  
        for (int i = 0; i < n; i++) {  
            System.out.println("线程【"+Thread.currentThread().getName()+"】-线程变量值【"+tlt.getNextNum()+"】");  
        }  
    }  
}   









