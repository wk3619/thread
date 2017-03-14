package com.jd.thread.concurrent.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


/**
 * 信号量，控制对资源的并发访问量
 * @author gongbinglai
 *
 */
public class SemaphoreTest {
    

    public static void main(String args[]){

        ExecutorService exec = Executors.newCachedThreadPool();

        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);

        for (int index = 0; index < 10; index++) {

              exec.execute(new SemaphoreThread(semp));
        }

	     // 退出线程池
	     exec.shutdown();
 
    }
    
}


class SemaphoreThread implements Runnable{

	private Semaphore semaphore;
	
	public SemaphoreThread(Semaphore semaphore){
		this.semaphore = semaphore;
	}
	
	public void run() {
		
		try {
			//获取许可数
			semaphore.acquire();
			
			System.out.println(Thread.currentThread().getName()+"获取许可数");
			
			Thread.sleep((long) (Math.random() * 2000));
			
			//释放许可数
			semaphore.release();

			System.out.println("当前可用许可数："+ semaphore.availablePermits());
		} catch (InterruptedException e) {

			e.printStackTrace();

		}
	}
	
}













