package com.jd.thread.lock.t1;

/**
 * Created by wangkai on 2019/4/7.
 */
public class MyThread extends Thread{
    private MyService myService;
    public MyThread(MyService myService){
        super();
        this.myService=myService;
    }
    @Override
    public void run(){
        myService.testMeThod();
    }
}
