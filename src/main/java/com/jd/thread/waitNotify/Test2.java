package com.jd.thread.waitNotify;

/**
 *
 * Created by wangkai on 2019/4/7.
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            String lock=new String("");
            System.out.println("syn 之前");
            synchronized(lock){
                System.out.println("begin");
                lock.wait();
                System.out.println("end");
            }
            System.out.println("syn 之后");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
