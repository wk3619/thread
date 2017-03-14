package com.jd.thread.waitNotify;

public class WareHouse {

	public static final int max_size = 100; // 最大库存量

	public int curnum; // 当前库存量

	WareHouse() {

	}
	WareHouse(int curnum) {
		this.curnum = curnum;
	}
	
	public synchronized void produce(int neednum) {
		
		if(neednum + curnum > max_size) {
			System.out.println("要生产的产品数量["+neednum+"]与库存量["+curnum+"]之和超过了库存上限["+max_size+"],，暂时不能执行生产任务!" );
			try {
				// 当前的生产线程等待，释放wareHouse对象锁
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		curnum += neednum;
		System.out.println("已经生产了" + neednum + "个产品，现仓储量为" + curnum);
		notifyAll();
	}

	public synchronized void consume(int neednum) {
		// 测试是否可消费
		if(curnum < neednum) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		curnum -= neednum;
		System.out.println("已经消费了" + neednum + "个产品，现仓储量为" + curnum);
		notifyAll();
	}
}
