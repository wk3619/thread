package com.jd.thread.syc;

/**
 * Created by wangkai on 2019/4/6.
 */
public class ThreadB extends Thread{
    private Service service;
    public ThreadB(Service service){
        super();
        this.service=service;
    }
    @Override
    public void run(){
        service.print("AA");
    }
}
