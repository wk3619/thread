package com.jd.thread.suspend;


public class SuspendResumeTest {
    

    public static void main(String args[]){
    	
    	SuspendThread obj = new SuspendThread();
    	
    	Thread t1 = new Thread(obj,"t1");
    	Thread t2 = new Thread(obj,"t2");
    	
    	
        try {
          Thread.sleep(1000);
          t1.suspend();
          System.out.println("Suspending thread t1");
          Thread.sleep(1000);
          t1.resume();
          System.out.println("Resuming thread t1");
          
          t2.suspend();
          System.out.println("Suspending thread t2");
          Thread.sleep(1000);
          t2.resume();
          System.out.println("Resuming thread t2");
          
        } catch (InterruptedException e) {
          System.out.println("Main thread Interrupted");
        }
        // wait for threads to finish
        try {
          System.out.println("Waiting for threads to finish.");
          t1.join();
          t2.join();
        } catch (InterruptedException e) {
          System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
    }
    
}


class SuspendThread implements Runnable {
	  
	 
	  // This is the entry point for thread.
	  public void run() {
	    try {
	      for(int i = 15; i > 0; i--) {
	        System.out.println(Thread.currentThread().getName() + ": " + i);
	        Thread.sleep(200);
	      }
	    } catch (InterruptedException e) {
	      System.out.println(Thread.currentThread().getName()  + " interrupted.");
	    }
	    System.out.println(Thread.currentThread().getName()  + " exiting.");
	  }
	}















