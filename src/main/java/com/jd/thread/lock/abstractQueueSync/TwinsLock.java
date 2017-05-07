package com.jd.thread.lock.abstractQueueSync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwinsLock implements Lock{

	
	private final MySync mySync = new MySync(2);

    private static final class MySync extends AbstractQueuedSynchronizer {

    	MySync(int count) {
            if (count <= 0) {
                throw new IllegalArgumentException("count must large than zero.");
            }
            setState(count);
        }

        //共享式同步状态的获取
        public int tryAcquireShared(int reduceCount) {
            for (; ; ) {//死循环---自旋
                int current = getState();
                int newCount = current - reduceCount;
//                if (newCount < 0 || compareAndSetState(current, newCount)) {
//                    return newCount;
//                }
                
//                if(newCount<0){
//                	return newCount;
//                }
                if(newCount>=0&&compareAndSetState(current, newCount)){
                	return newCount;
                }
                
                
                
            }
        }

        //共享式同步状态的释放
        public boolean tryReleaseShared(int returnCount) {
            for (; ; ) {
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }

        final ConditionObject newCondition() {
            return new ConditionObject();
        }

    }

	
	
	
    public void lock() {
    	mySync.acquireShared(1);
    }

    public void lockInterruptibly() throws InterruptedException {
    	mySync.acquireInterruptibly(1);
    }

    public boolean tryLock() {
        return mySync.tryAcquireShared(1) >= 0;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return mySync.tryAcquireSharedNanos(1,unit.toNanos(time));
    }

    public void unlock() {
    	mySync.releaseShared(1);
    }

    public Condition newCondition() {
        return mySync.newCondition();
    }

}
