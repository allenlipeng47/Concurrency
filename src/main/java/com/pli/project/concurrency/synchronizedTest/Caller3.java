package com.pli.project.concurrency.synchronizedTest;

public class Caller3 implements Runnable {

    SynchronizedStaticClass synchronizedClass;

    public Caller3(SynchronizedStaticClass synchronizedClass) {
        this.synchronizedClass = synchronizedClass;
    }

    public void run() {
        synchronizedClass.doSomething();
    }

    /*
    Call a synchronized static method belonging to different instances.
    */
    public static void main(String[] args) {
        SynchronizedStaticClass synchronizedClass1 = new SynchronizedStaticClass();
        SynchronizedStaticClass synchronizedClass2 = new SynchronizedStaticClass();
        Thread c1 = new Thread(new Caller3(synchronizedClass1));
        Thread c2 = new Thread(new Caller3(synchronizedClass2));
        c1.start();
        c2.start();
    }

}
