package com.jd.thread.manage.interrupt;

public class InterruptByFlagClient {
    public static void main(String[] args) throws InterruptedException{

        
    	 ThreadA ta=new ThreadA();
         ta.setName("ThreadA");
         ta.start();
         Thread.sleep(2000);
         System.out.println(ta.getName()+"正在被中断...");
         ta.interrupt();
         System.out.println("ta.isInterrupted()="+ta.isInterrupted());
    }
}
