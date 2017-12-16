package com.pli.project.concurrency.synchronizedTest;

public class Caller2 implements Runnable {

    SynchronizedDefaultClass synchronizedClass;

    public Caller2(SynchronizedDefaultClass synchronizedClass) {
        this.synchronizedClass = synchronizedClass;
    }

    public void run() {
        synchronizedClass.doSomething();
    }

    /*
    Call a synchronized method belonging to different instances.
    */
    public static void main(String[] args) {
        SynchronizedDefaultClass synchronizedClass1 = new SynchronizedDefaultClass();
        SynchronizedDefaultClass synchronizedClass2 = new SynchronizedDefaultClass();
        Thread c1 = new Thread(new Caller2(synchronizedClass1));
        Thread c2 = new Thread(new Caller2(synchronizedClass2));
        c1.start();
        c2.start();
    }

}
