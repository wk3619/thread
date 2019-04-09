package com.jd.thread.syc.o;

/**
 * Created by wangkai on 2019/4/6.
 */
public class ThreadBo extends Thread{
    private Serviceo service;
    public ThreadBo(Serviceo service){
        super();
        this.service=service;
    }
    @Override
    public void run(){
        service.print(new Object());
    }
}
