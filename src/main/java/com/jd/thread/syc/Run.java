package com.jd.thread.syc;

/**
 * Created by wangkai on 2019/4/6.
 */
public class Run {
    public static void main(String[] args) {
        Service service=new Service();
        ThreadA a=new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b=new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
