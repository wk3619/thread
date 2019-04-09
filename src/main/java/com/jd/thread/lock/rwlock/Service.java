package com.jd.thread.lock.rwlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wangkai on 2019/4/7.
 */
public class Service {
    private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    public void read(){
        lock.readLock();
        System.out.println("获得读锁"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }

    public void write(){
        lock.writeLock().lock();
        System.out.println("获得写锁"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }
}
