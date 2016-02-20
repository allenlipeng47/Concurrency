package com.pli.project.concurrency.util;

import java.util.HashMap;

/**
 * Created by pli on 2/11/2016.
 */
public class HashThread implements Runnable{

    public static Object mutex;

    public static HashMap<String, Long> hm;

    public HashThread() {
        mutex = new Object();
        if (hm == null) {
            hm = new HashMap<String, Long>();
            hm.put("a", 0l);
        }
    }


    public void run() {
        long endTime = System.currentTimeMillis() + 1000;
        while (System.currentTimeMillis() < endTime) {
            synchronized (mutex) {
                long value = hm.get("a");
                hm.put("a", ++value);
            }
        }
    }
}
