package com.jd.thread.waitNotify;

public class GodownConsumer extends Thread {

	private int neednum; // 生产产品的数量
	private Godown godown; // 仓库

	GodownConsumer(int neednum, Godown godown) {
		this.neednum = neednum;
		this.godown = godown;
	}

	public void run() {
		// 消费指定数量的产品
		godown.consume(neednum);
	}
}
