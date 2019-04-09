package com.jd.thread.lock.rwlock;

/**
 * Created by wangkai on 2019/4/7.
 *
 * 读读不锁定
 * 代写锁定
 *
 */
public class Run {
    public static void main(String[] args) {
        Service service=new Service();
        ThreadA a=new ThreadA(service);
        ThreadB b=new ThreadB(service);
        a.start();
        b.start();

    }
}
