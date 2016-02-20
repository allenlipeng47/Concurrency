package com.pli.project.concurrency;

import com.pli.project.concurrency.util.HashThread;

import java.util.HashMap;

/**
 * Created by pli on 2/11/2016.
 * <key, value>++
 */
public class MultiThreadCallHash {

    public static void main(String[] args) throws Exception{
        process();
    }

    // Main process. around 42M times.
    public static void process() throws Exception {
        HashMap<String, Long> hm = new HashMap<String, Long>();
        hm.put("a", 0l);
        long endTime = System.currentTimeMillis() + 1000;
        while (System.currentTimeMillis() < endTime) {
            long value = hm.get("a");
            hm.put("a", ++value);
        }
        System.out.println(hm.get("a"));
    }

    // 1 thread. 30M times.
    public static void singleThread() throws Exception{
        for (int i = 0; i < 1; i++) {
            (new Thread(new HashThread())).start();
        }
        Thread.sleep(1500);
        System.out.println(HashThread.hm.get("a"));
    }

    // Multiple threads. 12M times.
    public static void tenThread() throws Exception{
        for (int i = 0; i < 100; i++) {
            (new Thread(new HashThread())).start();
        }
        Thread.sleep(1500);
        System.out.println(HashThread.hm.get("a"));
    }

}
