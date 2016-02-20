package com.pli.project.concurrency;

import com.pli.project.concurrency.util.RedisThread;
import redis.clients.jedis.Jedis;

/**
 * Created by pli on 2/11/2016.
 * Test int++ in redis.
 * Single thread can reach 3000 times update per seconds.
 * Multi thread can reach 20000 times update per seconds.
 */
public class CallRedis {

    public static void main(String[] args) throws Exception{
        singleThread();
    }

    // around 3000 times
    public static void process() {
        Jedis jedis = new Jedis("ddpli");
        try {
            long endTime = System.currentTimeMillis() + 10000;
            while (System.currentTimeMillis() < endTime) {
                jedis.incr("a");
            }
        } catch (Exception e) {}
    }

    // around 3000 times
    public static void singleThread() {
        (new Thread(new RedisThread("ddpli"))).start();
    }

    // around 20000 times
    public static void multiThread() {
        for (int i = 0; i < 10; i++) {
            (new Thread(new RedisThread("ddpli"))).start();
        }
    }



}
