package com.jd.thread.lock.t2.t1;

/**
 * Created by wangkai on 2019/4/7.
 */
public class ThreadA extends Thread{
    private MyService myService;
    public ThreadA(MyService myService){
        super();
        this.myService=myService;
    }
    @Override
    public void run(){
        myService.methodA();
    }
}
