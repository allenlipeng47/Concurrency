package com.pli.project.concurrency.util;

/**
 * Created by pli on 2/11/2016.
 */
public class LongThread implements Runnable{

    public static Object mutex;

    public static long num;

    public LongThread() {
        mutex = new Object();
    }


    public void run() {
        long endTime = System.currentTimeMillis() + 1000;
        while (System.currentTimeMillis() < endTime) {
            synchronized (mutex) {
                num++;
            }
        }
    }
}
