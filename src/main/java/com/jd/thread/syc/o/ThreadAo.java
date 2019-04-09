package com.jd.thread.syc.o;

import com.jd.thread.syc.Service;

/**
 * Created by wangkai on 2019/4/6.
 */
public class ThreadAo extends Thread{
    private Serviceo service;
    public ThreadAo(Serviceo service){
        super();
        this.service=service;
    }
    @Override
    public void run(){
        service.print(new Object());
    }
}
