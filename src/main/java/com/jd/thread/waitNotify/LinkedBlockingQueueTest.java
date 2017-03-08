package com.jd.thread.waitNotify;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * 借助LinkedBlockingQueue来实现生产者消费者模式
 * @author gongbinglai
 *
 */
public class LinkedBlockingQueueTest {
    

    
    public static void main(String args[]){
    	BlockingQueue sharedQueue = new LinkedBlockingQueue(10);

        Thread prodThread = new Thread(new LBQProducer(sharedQueue));
        Thread consThread = new Thread(new LBQConsumer(sharedQueue));
        
        prodThread.start();
        consThread.start();
    }
    
    
}


//Producer Class in java
class LBQProducer implements Runnable {

  private final BlockingQueue sharedQueue;

  public LBQProducer(BlockingQueue sharedQueue) {
      this.sharedQueue = sharedQueue;
  }

  public void run() {
      for(int i=0; i<10; i++){
          try {
              System.out.println("Produced: " + i);
              //将元素放入队列
              sharedQueue.put(i);
          } catch (InterruptedException ex) {
        	  ex.printStackTrace();
          }
      }
  }

}

class LBQConsumer implements Runnable{

  private final BlockingQueue sharedQueue;

  public LBQConsumer (BlockingQueue sharedQueue) {
      this.sharedQueue = sharedQueue;
  }

  public void run() {
      while(true){
          try {
              System.out.println("Consumed: "+ sharedQueue.take());
          } catch (InterruptedException ex) {
        	  ex.printStackTrace();
          }
      }
  }

}
















