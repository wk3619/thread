package com.jd.thread.syc;

/**
 * Created by wangkai on 2019/4/6.
 */
public class Service {
    public static void print (String param){
        try {
            synchronized (param){
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
