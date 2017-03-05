package com.jd.thread.manage.interrupt;

public class InterruptMethodTest {
    
	
	public static void main(String[] args){


	 InterruptMethodThread ta=new InterruptMethodThread();
     ta.start();
      try {
		Thread.sleep(1);
		ta.interrupt();
	    
		//true true
	    System.out.println("是否停止1："+ta.isInterrupted());
	    System.out.println("是否停止2："+ta.isInterrupted());
	    
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
     
      System.out.println("end");
      
    }
	
}



class InterruptMethodThread extends  Thread{

	
	public void run() {
		
		for(int i=0;i<1000;i++){
			System.out.println("i="+(i+1));
		}
		
	}
}





