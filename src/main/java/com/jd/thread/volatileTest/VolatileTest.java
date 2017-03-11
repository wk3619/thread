package com.jd.thread.volatileTest;



/**
 * 借助LinkedBlockingQueue来实现生产者消费者模式
 * @author gongbinglai
 *
 */
public class VolatileTest{
    
	
    public static void main(String[] args) throws InterruptedException {
    	
    	VolatileThread volatileThread = new VolatileThread("t1");
        volatileThread.start();
        Thread.sleep(2000);
        
        
        //当jvm被设置为server模式时，线程执行时获取的为私有栈中的变量，
        //volatileThread.setRunning设置的为公共内存中的变量，所以线程不会停止
        volatileThread.setRunning(false);
        
        System.out.println("isUpdated的值被修改为为false,线程被停止了");
    }
	
}




class VolatileThread extends Thread{
	
	//private boolean isRunning = true;
	
	private volatile boolean isRunning = true;
	
	private String name;

	public VolatileThread(String name){
		this.name = name;
	}
	
    public boolean isRunning(){
        return isRunning;
    }

    public void setRunning(boolean isRunning){
        this.isRunning= isRunning;
    }

    public void run(){
        
        while (isRunning){
        	System.out.println("线程:"+name+" isRunning.........");
        	try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
}








