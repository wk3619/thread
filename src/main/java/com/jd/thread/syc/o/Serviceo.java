package com.jd.thread.syc.o;

/**
 * Created by wangkai on 2019/4/6.
 */
public class Serviceo {
    public static void print (Object o){
        try {
            synchronized (o){
                while (true){
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
