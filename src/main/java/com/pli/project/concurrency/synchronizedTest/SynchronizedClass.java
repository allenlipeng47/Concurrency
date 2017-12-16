package com.pli.project.concurrency.synchronizedTest;

public class SynchronizedClass {

    public static int a;

    // with synchronized, this method could be called only by 1 thread.
    public synchronized void doSomething() {
        for (int i = 0; i < 5; i++) {
            a++;
            System.out.println(String.format("Thread: %s, value: %d", Thread.currentThread().getId(), a));
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }

}
