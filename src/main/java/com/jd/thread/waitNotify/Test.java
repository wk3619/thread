package com.jd.thread.waitNotify;

/**
 * Created by wangkai on 2019/4/7.
 */
public class Test {


    public static void main(String[] args) {
        Object lock =new Object();
        MyThread1 t1=new MyThread1(lock);
        MyThread2 t2=new MyThread2(lock);
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
