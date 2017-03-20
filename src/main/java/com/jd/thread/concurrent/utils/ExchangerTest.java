package com.jd.thread.concurrent.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 数据交换
 * @author gongbinglai
 *
 */
public class ExchangerTest {
    

    public static void main(String args[]){
    	
    	Exchanger<List<Integer>> exchanger = new Exchanger<List<Integer>>();
    	
    	Thread t1 = new Thread(new ExchangerProducer(exchanger));
    	Thread t2 = new Thread(new ExchangerConsumer(exchanger));
    	
    	t1.start();
    	t2.start();
  
    }
    
}


class ExchangerProducer implements Runnable {     
    
	private Exchanger<List<Integer>> exchanger = null;  
    
    public ExchangerProducer(Exchanger<List<Integer>> exchanger) {     
         this.exchanger = exchanger;
    }     
    
    public void run() {     
        try {     
             
        	List<Integer> beforeList = new ArrayList<Integer>();
        	beforeList.add(11);
        	beforeList.add(12);
        	
            System.out.println("线程"+Thread.currentThread().getName()+"正在把数据换出去");
            Thread.sleep((long)(Math.random()*2000));
            List<Integer> afterList = exchanger.exchange(beforeList);
                 
            for(Integer i:afterList){
            	 System.out.println("ExchangerProducer交换后数据："+i);
            }
           
         } catch (InterruptedException e) {     
             e.printStackTrace();     
         } 
     }     
}    


class ExchangerConsumer implements Runnable {     
    
	private Exchanger<List<Integer>> exchanger = null;  
    
    public ExchangerConsumer(Exchanger<List<Integer>> exchanger) {     
         this.exchanger = exchanger;
    }     
    
    public void run() {     
        try {     
             
        	List<Integer> beforeList = new ArrayList<Integer>();
        	beforeList.add(21);
        	beforeList.add(22);
        	
            System.out.println("线程"+Thread.currentThread().getName()+"正在把数据换出去");
            Thread.sleep((long)(Math.random()*2000));
            List<Integer> afterList = exchanger.exchange(beforeList);
                 
            for(Integer i:afterList){
            	 System.out.println("ExchangerConsumer交换后数据："+i);
            }
           
         } catch (InterruptedException e) {     
             e.printStackTrace();     
         } 
     }     
}   












