package com.pli.project.concurrency;

import com.pli.project.concurrency.util.LongThread;

/**
 * Created by pli on 2/11/2016.
 * Test long++
 */
public class MultiThreadCallLong {

    public static void main(String[] args) throws Exception{
        TenThread();
    }

    // 1 thread. 30M times.
    public static void singleThread() throws Exception{
        for (int i = 0; i < 1; i++) {
            (new Thread(new LongThread())).start();
        }
        Thread.sleep(1500);
        System.out.println(LongThread.num);
    }

    // Multiple threads. 18M times.
    public static void TenThread() throws Exception{
        for (int i = 0; i < 100; i++) {
            (new Thread(new LongThread())).start();
        }
        Thread.sleep(1500);
        System.out.println(LongThread.num);
    }

}
