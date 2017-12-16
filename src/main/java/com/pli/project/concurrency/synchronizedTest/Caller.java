package com.pli.project.concurrency.synchronizedTest;

public class Caller implements Runnable {

    SynchronizedClass synchronizedClass;

    public Caller(SynchronizedClass synchronizedClass) {
        this.synchronizedClass = synchronizedClass;
    }

    public void run() {
        synchronizedClass.doSomething();
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId());
        SynchronizedClass synchronizedClass = new SynchronizedClass();
        Thread c1 = new Thread(new Caller(synchronizedClass));
        Thread c2 = new Thread(new Caller(synchronizedClass));
        c1.start();
        c2.start();
    }
}
