package com.jd.thread.executor;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class FutureTaskTest {

	public static void main(String[] args) throws InterruptedException {
        Callable<Integer> pAccount = new PrivateAccount();  
        FutureTask<Integer> futureTask = new FutureTask<Integer>(pAccount);  
        Thread pAccountThread = new Thread(futureTask);  
        pAccountThread.start();  
        
        int totalMoney = new Random().nextInt(100000);  
        // 测试后台的计算线程是否完成，如果未完成则等待  
        while (!futureTask.isDone()) {  
            try {  
                Thread.sleep(500);  
                System.out.println("私有账户计算未完成继续等待...");  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        Integer privateAccountMoney = null;  
        try {  
            privateAccountMoney = (Integer) futureTask.get();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (ExecutionException e) {  
            e.printStackTrace();  
        }  
        System.out.println("您现在的总金额为：" + (totalMoney + privateAccountMoney.intValue()));  
	}

}


class PrivateAccount implements Callable<Integer> {  
    Integer totalMoney;  
  
    public Integer call() throws Exception {  
        
    	Thread.sleep(5000);  
        totalMoney = new Integer(new Random().nextInt(10000));  
        System.out.println("您当前有" + totalMoney + "在您的私有账户中");  
        return totalMoney;  
    }  
  
}  






















