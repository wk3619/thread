package com.jd.thread.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPoolExecutorTest {

	
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
	
	
	private static class MyCallableThread implements Callable<String> {

		private String name;

		public MyCallableThread(String name) {
			this.name = name;
		}

		public String call() throws Exception {
			Thread.sleep(1000);
			return "callable";
		}
	}
	
	

	public static void main(String[] args) throws InterruptedException {
      BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(2);
      BlockingQueue<Runnable> queue2 = new LinkedBlockingQueue<Runnable>();
//      BlockingQueue<Runnable> queue = new PriorityBlockingQueue<Runnable>();
//      BlockingQueue<Runnable> queue = new SynchronousQueue<Runnable>();

      
      // AbortPolicy/CallerRunsPolicy/DiscardOldestPolicy/DiscardPolicy
      ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS,
              queue, new ThreadPoolExecutor.AbortPolicy());

      // 向线程池里面扔任务
//      for (int i = 0; i < 10; i++) {
//          System.out.println("当前线程池大小[" + threadPool.getPoolSize() + "],当前队列大小[" + queue.size() + "]");
//
//          threadPool.execute(new MyThread("Thread" + i));
//      }
      
      MyCallableThread thread = new MyCallableThread("t1");
      
      Future<String> future = threadPool.submit(thread);
      
      
      try {
    	  System.out.println("开始获取结果");
		String result = future.get();
		System.out.println(result);
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		// 关闭线程池
	      threadPool.shutdown();
	}
      
      
	}

}
