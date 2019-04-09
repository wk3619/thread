package com.jd.thread.yield;


public class YieldTest {
    

    public static void main(String args[]){
    	
    	Thread producer = new Producer();
        Thread consumer = new Consumer();
   
        producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
        consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority
   
        producer.start();
        consumer.start();
    }
    
}

class Producer extends Thread{
   public void run(){
      Long startTime= System.currentTimeMillis();
      for (int i = 0; i < 5000; i++){
         System.out.println("I am Producer : Produced Item " + i);
        // Thread.yield();
      }
      Long endTime=System.currentTimeMillis();
       System.out.println("Producer execute time "+(endTime-startTime));
   }
}
 
class Consumer extends Thread{
   public void run(){
       Long startTime= System.currentTimeMillis();
      for (int i = 0; i < 5000; i++){
         System.out.println("I am Consumer : Consumed Item " + i);
       //  Thread.yield();
      }
       Long endTime=System.currentTimeMillis();
       System.out.println("Consumer execute time "+(endTime-startTime));
   }
}















