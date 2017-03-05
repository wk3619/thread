package com.jd.thread.manage.interrupt;

public class InterruptBlockingThreadTest {
    
	
	public static void main(String[] args) throws InterruptedException{

//		ProcessExceptionOuterWhile ta=new ProcessExceptionOuterWhile();
//        ta.start();
//        Thread.sleep(2000);
//        ta.interrupt();
		
		
	  ProcessExceptionInWhile ta=new ProcessExceptionInWhile();
      ta.start();
      Thread.sleep(2000);
      
      ta.interrupt();
    }
	
}



class ProcessExceptionOuterWhile extends  Thread{

	
	public void run() {
		
		int num =0 ;
		try {
		     while (true) {
		        System.out.println("====num当前值为==="+num++);
		        Thread.sleep(400);
		     }
		 } catch (InterruptedException ie) {  
		    System.out.println(this.isInterrupted());
		    //return;  如果不加return的话后面的逻辑处理还是会执行的，抛出异常只是结束while循环
		}
		System.out.println("====ProcessExceptionOuterWhile线程中断后处理===");
	}
}


class ProcessExceptionInWhile extends  Thread{

	
	public void run() {
		
		int num =0 ;
		
	     while (true) {
	    	 try{
	    		 System.out.println("====num当前值为==="+num++);
			     Thread.sleep(500); 
	    	 }catch(InterruptedException ie){
	    		 System.out.println(this.isInterrupted());
	    		 ie.printStackTrace();
	    		 break;  //如果不加break或return，会一直执行while循环
	    	 }
	       
	     }
		
		System.out.println("====ProcessExceptionInWhile线程中断后处理===");
	}
}




