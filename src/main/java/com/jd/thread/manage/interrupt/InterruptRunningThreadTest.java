package com.jd.thread.manage.interrupt;

public class InterruptRunningThreadTest {
    
	
	public static void main(String[] args) throws InterruptedException{


	  InterruptByCommon ta=new InterruptByCommon();
      ta.start();
      Thread.sleep(100);
      ta.interrupt();
      
      
//	  InterruptByOtherFlag ta=new InterruptByOtherFlag();
//      ta.start();
//      Thread.sleep(100);
//      ta.stopTask();
    }
	
}



class InterruptByCommon extends  Thread{

	
	public void run() {
		
		int num =0 ;
		while (!this.isInterrupted()) {
			System.out.println("====num当前值为==="+num++);
	    }
		System.out.println("线程已经终止!");
		
	}
}

class InterruptByOtherFlag extends  Thread{

	 private volatile boolean isInterrupted=false;
	 int count=0;
	   
	   public void stopTask(){
	       isInterrupted = true;
	       super.interrupt();
	   }
	   
	   public void run(){
	       while(!isInterrupted){
	           System.out.println(getName()+"运行中"+count++);
	       }
	       System.out.println(getName()+"已经终止!");
	   }
}



