package com.pli.project.concurrency.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import redis.clients.jedis.Jedis;

import javax.sql.DataSource;

/**
 * Created by pli on 2/11/2016.
 */
public class MysqlThread implements Runnable{

    ApplicationContext context;
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    public MysqlThread(ApplicationContext context) {
        this.context = context;
        dataSource = (DataSource)context.getBean("dataSource");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void run() {
        long endTime = System.currentTimeMillis() + 10000;
        try {
            while (System.currentTimeMillis() < endTime) {
                jdbcTemplate.execute("update test set counter = counter + 1");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
