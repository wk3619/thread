package com.jd.thread.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

	private static int threadCount = 3;
	private static CountDownLatch countDown = new CountDownLatch(threadCount);
	public static AtomicReference<User> atomicUserRef = new AtomicReference<User>();

	private static class ReferenceUpdater implements Runnable {
		User user;

		public ReferenceUpdater(User user) {
			this.user = user;
		}

		public void run() {
			for (int i = 0; i < 3; i++) {
				User oldUser = atomicUserRef.get();
				
				if(oldUser!=null){
					System.out.println(Thread.currentThread().getName()+",oldUser:"+oldUser.getName()+","+oldUser.getOld());
				}
				//如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值
				atomicUserRef.compareAndSet(oldUser, user);
				if(user!=null){
					System.out.println(Thread.currentThread().getName()+",newUser:"+user.getName()+","+user.getOld());
				}
				Thread.yield();
				
			}
			countDown.countDown();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[threadCount];
		for (int i = 0; i < threadCount; i++) {
			threads[i] = new Thread(new ReferenceUpdater(
					new User("name" + i, i)));
		}
		for (int i = 0; i < threadCount; i++) {
			threads[i].start();
		}
		countDown.await();
		System.out.println(atomicUserRef.get().getName());
		System.out.println(atomicUserRef.get().getOld());
	}

	static class User {
		private String name;
		private int old;

		public User(String name, int old) {
			this.name = name;
			this.old = old;
		}

		public String getName() {
			return name;
		}

		public int getOld() {
			return old;
		}
	}
}
