package com.jd.thread.executor;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPoolShuwdownTest {

	
	private static class MyThread implements Runnable {

		private String name;

		public MyThread(String name) {
			this.name = name;
		}

		public void run() {
			try {
				Thread.sleep(1000);
				System.out.println(name + " finished job!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		
	}
	


	public static void main(String[] args) throws InterruptedException {
      BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(1000);
      
      ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS,
              queue, new ThreadPoolExecutor.AbortPolicy());

      //向线程池里面扔任务
      for (int i = 0; i < 50; i++) {
          System.out.println("当前线程池大小[" + threadPool.getPoolSize() + "],当前队列大小[" + queue.size() + "]");

          threadPool.execute(new MyThread("Thread" + i));
          
      }
      
      Thread.sleep(10000);
     
      
      threadPool.shutdown();
      
//      List<Runnable> threadList = threadPool.shutdownNow();
//      
//      System.out.println("========停止的线程========"+threadList.size());
      
      System.out.println("====isShutdown======"+threadPool.isShutdown());
      System.out.println("====isTerminated======"+threadPool.isTerminated());
      System.out.println("====isTerminating======"+threadPool.isTerminating());
      
	}

}
