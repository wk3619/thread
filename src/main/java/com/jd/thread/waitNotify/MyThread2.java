package com.jd.thread.waitNotify;

/**
 * Created by wangkai on 2019/4/7.
 */
public class MyThread2 extends Thread{
    private Object lock;
    public MyThread2(Object lock){
        super();
        this.lock=lock;
    }
    @Override
    public void run(){

            synchronized (lock){
                System.out.println("开始 notify time= "+System.currentTimeMillis());
                lock.notify();
                System.out.println("end notify time= "+System.currentTimeMillis());

            }

    }
}
