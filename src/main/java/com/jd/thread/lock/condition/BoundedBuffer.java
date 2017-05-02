package com.jd.thread.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class BoundedBuffer {
    
	final Lock lock = new ReentrantLock();//锁对象  
	final Condition writeCondition  = lock.newCondition();//写线程条件   writeCondition
	final Condition readCondition = lock.newCondition();//读线程条件 readCondition   
	
	final Object[] items = new Object[10];//缓存队列  
	int putptr/*写索引*/, takeptr/*读索引*/, count/*队列中存在的数据个数*/;  

	public void put(Object x) throws InterruptedException {  
	     lock.lock();  
	     try {  
	       while (count == items.length){
	    	   System.out.println("队列满，阻塞写线程");
	    	   writeCondition.await();
	       }
	       
	       System.out.println("在索引"+putptr+"写入对象:"+x);
	       items[putptr] = x;//赋值   
	       if (++putptr == items.length) putptr = 0;//如果写索引写到队列的最后一个位置了，那么置为0  
	       ++count;//个数++  
	       readCondition.signal();//唤醒一个读线程  readCondition   
	     } finally {  
	       lock.unlock();  
	     }  
	 }  


	   //读取
	   public Object take() throws InterruptedException {  
	     lock.lock();  
	     try {  
	       while (count == 0){
	    	   System.out.println("队列空，阻塞读线程");
	    	   readCondition.await();
	       }
	       Object x = items[takeptr];//取值   
	       System.out.println("在索引"+putptr+"弹出对象:"+x);
	       if (++takeptr == items.length) takeptr = 0;//如果读索引读到队列的最后一个位置了，那么置为0  
	       --count;//个数--  
	       writeCondition.signal();//唤醒写线程  writeCondition
	       return x;  
	     } finally {  
	       lock.unlock();  
	     }  
	   }   
   
}





