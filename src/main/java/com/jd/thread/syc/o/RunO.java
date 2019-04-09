package com.jd.thread.syc.o;

import com.jd.thread.syc.Service;
import com.jd.thread.syc.ThreadA;
import com.jd.thread.syc.ThreadB;

/**
 * Created by wangkai on 2019/4/6.
 */
public class RunO {
    public static void main(String[] args) {
        Serviceo service=new Serviceo();
        ThreadAo a=new ThreadAo(service);
        a.setName("A");
        a.start();

        ThreadBo b=new ThreadBo(service);
        b.setName("B");
        b.start();
    }
}
