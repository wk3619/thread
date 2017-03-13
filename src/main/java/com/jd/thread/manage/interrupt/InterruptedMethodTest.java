package com.jd.thread.manage.interrupt;

public class InterruptedMethodTest {
    
	
	public static void main(String[] args){


	 InterruptMethodThread ta=new InterruptMethodThread();
     ta.start();
	 try {
		Thread.sleep(1000);
		
		//中断当前线程，注意不是ta.interrupt
		//Thread.currentThread().interrupt();
	    
		ta.interrupt();
		
	     //interrupted判断当前线程是否中断，并清空中断标记位，执行结果为true  false false false
	    System.out.println(ta.interrupted());
	    System.out.println(ta.interrupted());
	      
	    System.out.println(Thread.interrupted());
	    System.out.println(Thread.interrupted());
		
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	 
     System.out.println("end");
      
    }
	
}



class InterruptedMethodThread extends  Thread{

	
	public void run() {
		
		for(int i=0;i<50000;i++){
			
			System.out.println("i="+(i+1));
		}
		
	}
}





