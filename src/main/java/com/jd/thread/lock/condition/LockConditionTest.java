package com.jd.thread.lock.condition;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class LockConditionTest {
    

    public static void main(String args[]) throws InterruptedException, ExecutionException{
    	
    	
    	BoundedBuffer buffer = new BoundedBuffer();
    	
    	ExecutorService producerPool = Executors.newCachedThreadPool();
    	ExecutorService consumerPool = Executors.newCachedThreadPool();
    	
    	
    	for(int i=0;i<20;i++){
    		Thread.sleep(1000);
    		producerPool.execute(new BoundedBufferProducer(buffer,"name_"+i));
    	}
    	
    	Thread.sleep(2000);
    	
    	for(int i=0;i<20;i++){
    		Thread.sleep(1000);
    		consumerPool.execute(new BoundedBufferConsumer(buffer));
    	}
    	
    	producerPool.shutdown();
    	consumerPool.shutdown();
    	
    	
    	
    }
    
}

class BoundedBufferProducer implements  Runnable{

	private BoundedBuffer buffer;
	private String name;
	
	
	public BoundedBufferProducer(BoundedBuffer buffer,String name){
		this.buffer = buffer;
		this.name = name;
	}
	
	
	public void run() {
		
		try {
			buffer.put(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class BoundedBufferConsumer implements  Runnable{

	private BoundedBuffer buffer;
	
	public BoundedBufferConsumer(BoundedBuffer buffer){
		this.buffer = buffer;
	}
	
	public void run() {
		
		try {
			buffer.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}










