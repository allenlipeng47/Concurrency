package com.pli.project.concurrency.synchronizedTest;

public class Caller1 implements Runnable {

    SynchronizedDefaultClass synchronizedClass;

    public Caller1(SynchronizedDefaultClass synchronizedClass) {
        this.synchronizedClass = synchronizedClass;
    }

    public void run() {
        synchronizedClass.doSomething();
    }

    /*
    Call a synchronized method belonging to same instance.
     */
    public static void main(String[] args) {
        SynchronizedDefaultClass synchronizedClass = new SynchronizedDefaultClass();
        Thread c1 = new Thread(new Caller1(synchronizedClass));
        Thread c2 = new Thread(new Caller1(synchronizedClass));
        c1.start();
        c2.start();
    }

}
