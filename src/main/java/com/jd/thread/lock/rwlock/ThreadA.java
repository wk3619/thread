package com.jd.thread.lock.rwlock;

import com.jd.thread.lock.t2.t1.MyService;

/**
 * Created by wangkai on 2019/4/7.
 */
public class ThreadA extends Thread{
    private Service service;
    public ThreadA(Service service){
        super();
        this.service=service;
    }
    @Override
    public void run(){
        service.write();
    }
}
