package com.jd.thread.lock.t2.t1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangkai on 2019/4/7.
 */
public class MyService {
    private Lock lock = new ReentrantLock();

    public void methodA() {
        lock.lock();

        try {
            System.out.println("methodA begin " + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodB end" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void methodB() {
        lock.lock();

        try {
            System.out.println("methodA begin " + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodB end" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
