package com.jd.thread.waitNotify;

/**
 * 必须对象锁，才能用wait，否则IllegalMonitorStateException
 * wait释放锁
 *
 * Created by wangkai on 2019/4/7.
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            String newString=new String("");
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
