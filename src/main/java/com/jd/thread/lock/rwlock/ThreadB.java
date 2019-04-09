package com.jd.thread.lock.rwlock;

/**
 * Created by wangkai on 2019/4/7.
 */
public class ThreadB extends Thread{
    private Service service;
    public ThreadB(Service service){
        super();
        this.service=service;
    }
    @Override
    public void run(){
        service.write();
    }
}
