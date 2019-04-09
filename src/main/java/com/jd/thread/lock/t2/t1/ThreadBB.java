package com.jd.thread.lock.t2.t1;

/**
 * Created by wangkai on 2019/4/7.
 */
public class ThreadBB extends Thread{
    private MyService myService;
    public ThreadBB(MyService myService){
        super();
        this.myService=myService;
    }
    @Override
    public void run(){
        myService.methodB();
    }
}
