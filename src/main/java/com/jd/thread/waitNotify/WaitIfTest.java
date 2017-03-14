package com.jd.thread.waitNotify;




public class WaitIfTest {

	public static void main(String args[]) {
		
		
		/**
		 * 仓库初始30  最大容量100 
		 */
		WareHouse wareHouse = new WareHouse(30);

		//消费30
		WareHouseConsumer c1 = new WareHouseConsumer(50, wareHouse);
		WareHouseConsumer c2 = new WareHouseConsumer(20, wareHouse);
		WareHouseConsumer c3 = new WareHouseConsumer(30, wareHouse);

		//生产10
		WareHouseProducer p1 = new WareHouseProducer(10, wareHouse);
		WareHouseProducer p2 = new WareHouseProducer(10, wareHouse);
		WareHouseProducer p3 = new WareHouseProducer(10, wareHouse);
		WareHouseProducer p4 = new WareHouseProducer(10, wareHouse);
		WareHouseProducer p5 = new WareHouseProducer(10, wareHouse);
		WareHouseProducer p6 = new WareHouseProducer(10, wareHouse);
		WareHouseProducer p7 = new WareHouseProducer(80, wareHouse);

				c1.start();
				c2.start();
				c3.start();

				p7.start();
				p1.start();
				p2.start();
				p3.start();
				p4.start();
				p5.start();
				p6.start();
	}
}


class WareHouseConsumer extends Thread {

	private int neednum; // 生产产品的数量
	private WareHouse wareHouse; // 仓库

	WareHouseConsumer(int neednum, WareHouse wareHouse) {
		this.neednum = neednum;
		this.wareHouse = wareHouse;
	}

	public void run() {
		// 消费指定数量的产品
		wareHouse.consume(neednum);
	}
}


class WareHouseProducer extends Thread {

	private int neednum; // 生产产品的数量
	private WareHouse wareHouse; // 仓库

	WareHouseProducer(int neednum, WareHouse wareHouse) {
		this.neednum = neednum;
		this.wareHouse = wareHouse;
	}

	public void run() {
		// 消费指定数量的产品
		wareHouse.produce(neednum);
	}
}














