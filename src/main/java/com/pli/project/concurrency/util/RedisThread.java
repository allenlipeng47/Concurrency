package com.pli.project.concurrency.util;

import redis.clients.jedis.Jedis;

/**
 * Created by pli on 2/11/2016.
 */
public class RedisThread implements Runnable{

    Jedis jedis;

    public RedisThread(String host) {
        jedis = new Jedis(host);
    }

    public void run() {
        try {
            long endTime = System.currentTimeMillis() + 10000;
            while (System.currentTimeMillis() < endTime) {
                jedis.incr("a");
            }
        } catch (Exception e) {}
    }


}
