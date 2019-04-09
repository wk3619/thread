package com.jd.thread.concurrent.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CountDownLatchTest {
    
	private static final int PLAY_AMOUNT = 5;

    public static void main(String args[]){
    	
    	CountDownLatch begin = new CountDownLatch(1);   
        CountDownLatch end = new CountDownLatch(PLAY_AMOUNT);  
        
       Player[] plays = new Player[PLAY_AMOUNT];     
       for(int i = 0;i<PLAY_AMOUNT;i++) {     
            plays[i] = new Player(i+1,begin,end);     
       }     
       ExecutorService exe = Executors.newFixedThreadPool(PLAY_AMOUNT);     
       
       for(Player p : plays) {//各就各位     
            exe.execute(p);  
        }     
        System.out.println("比赛开始"+System.nanoTime());
        System.out.println("比赛开始"+System.currentTimeMillis());
        begin.countDown();//宣布开始
       try {     
            end.await();//等待结束     
        } catch (InterruptedException e) {     
            e.printStackTrace();     
        } finally {     
            System.out.println("比赛结束"+System.nanoTime());
        }     
       //注意：此时main线程已经要结束了，但是exe线程如果不关闭是不会结束的     
        exe.shutdown();     
    }
    
}


class Player implements Runnable {     
    
    private int id;     
    private CountDownLatch begin;     
    private CountDownLatch end;     
    
    public Player(int id, CountDownLatch begin, CountDownLatch end) {     
        super();     
        this.id = id;     
        this.begin = begin;     
        this.end = end;     
     }     
    
    public void run() {     
        try {     
             
        	 begin.await();//必须等到裁判countdown到0的时候才开始     
        	 System.out.println("Play "+id+" running "+System.currentTimeMillis());


            Thread.sleep((long)(Math.random()*1000));//模拟跑步需要的时间
             System.out.println("Play "+id+" has arrived. "+System.currentTimeMillis());
                 
         } catch (InterruptedException e) {     
             e.printStackTrace();     
         } finally {     
             end.countDown();//向评委报告跑到终点了     
         }     
     }     
}    















