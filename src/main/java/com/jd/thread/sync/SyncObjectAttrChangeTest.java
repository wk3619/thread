package com.jd.thread.sync;


/**
 * 同步代码块测试
 * @author gongbinglai
 *
 */
public class SyncObjectAttrChangeTest {
    
	
	public static void main(String[] args) throws InterruptedException{

		
		SyncObjectAttrChangeService service = new SyncObjectAttrChangeService();
		SyncObjectAttrChangeThread t1 = new SyncObjectAttrChangeThread(service);
		SyncObjectAttrChangeThread t2 = new SyncObjectAttrChangeThread(service);
		
		t1.setName("t1");
		t2.setName("t2");
		
		t1.start();
		
		
		//注意是让当前线程休眠1000ms，然后再启动t2，不是让t1睡眠
		Thread.sleep(1000);
		
		//如果不让当前线程休眠的话，那么t1 t2同时竞争123的对象锁，同步输出
		t2.start();
		
		
    }
	
}

class SyncObjectAttrChangeService{

	private User user = new User("zhangsan",20);
    
    public void methodA() {
    	
    	synchronized(user){
    		
    		System.out.println("线程"+Thread.currentThread().getName()+" begin");
    		
    		user.setUserName("lisi");
    		
    		try {
				Thread.sleep(2000);
				
				System.out.println("线程"+Thread.currentThread().getName()+" end");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		
    		
    	}
    }
 }


class SyncObjectAttrChangeThread extends Thread{

	private SyncObjectAttrChangeService service;
	
	public SyncObjectAttrChangeThread(SyncObjectAttrChangeService service){
		this.service = service;
	}
	
	
    public void run() {
    	
    	service.methodA();
    }
 }

class User{
	
	private String userName;
	private int age;
	
	
	public User(String userName,int age){
		this.userName = userName;
		this.age = age;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}














