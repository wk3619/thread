package com.jd.thread.waitNotify;

public class GodownTest {

	public static void main(String args[]) {
		//当前库存30
		Godown godown = new Godown(30);

		//消费30
		GodownConsumer c1 = new GodownConsumer(50, godown);
		GodownConsumer c2 = new GodownConsumer(20, godown);
		GodownConsumer c3 = new GodownConsumer(30, godown);

		//生产10
		GodownProducer p1 = new GodownProducer(10, godown);
		GodownProducer p2 = new GodownProducer(10, godown);
		GodownProducer p3 = new GodownProducer(10, godown);
		GodownProducer p4 = new GodownProducer(10, godown);
		GodownProducer p5 = new GodownProducer(10, godown);
		GodownProducer p6 = new GodownProducer(10, godown);
		GodownProducer p7 = new GodownProducer(80, godown);

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
