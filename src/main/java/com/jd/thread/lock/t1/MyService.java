package com.jd.thread.lock.t1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangkai on 2019/4/7.
 */
public class MyService {
    private Lock lock=new ReentrantLock();
    public void testMeThod(){
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadName="+Thread.currentThread().getName()+(" "+(i+1)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
    }

}
