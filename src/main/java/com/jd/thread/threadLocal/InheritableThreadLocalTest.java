package com.jd.thread.threadLocal;


public class InheritableThreadLocalTest {
    

    public static void main(String args[]){
    	
    	final ThreadLocal<String> local = new InheritableThreadLocal<String>();  
        work(local);  
    	
    }
    
    private static void work(final ThreadLocal<String> local) {  
        local.set("a");  
        System.out.println(Thread.currentThread() + "," + local.get());  
        
        //定义子线程
        Thread t = new Thread(new Runnable() {  
              
            public void run() {  
            	//子线程可以看到父线程的值，因此此时打印a值
            	System.out.println(Thread.currentThread() + "," + local.get());  
                local.set("b");  
                System.out.println(Thread.currentThread() + "," + local.get());  
            }  
        });  
          
        t.start();  
        try {  
            t.join();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        
        //父线程是看不到子线程的修改，所以此时还是a值
        System.out.println(Thread.currentThread() + "," + local.get());  
    }  
    
    
    
    
}










