package com.pli.project.concurrency;

import com.pli.project.concurrency.util.MysqlThread;
import com.pli.project.concurrency.util.RedisThread;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by pli on 2/12/2016.
 */
public class CallMysql {

    public static ApplicationContext context;


    public static void main(String[] args) throws Exception{
        String[] springConfig  =
                {
                        "spring-config.xml"
//                                "file:/home/redis/concurrency/spring-config.xml"
                };

        context = new ClassPathXmlApplicationContext(springConfig);

        multiThread();

    }

    public static void process() throws Exception{
        DataSource dataSource = (DataSource)context.getBean("dataSource");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        long endTime = System.currentTimeMillis() + 10000;

        jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
        while (System.currentTimeMillis() < endTime) {
            jdbcTemplate.execute("update test set counter = counter + 1");
        }
    }




    public static void multiThread() {
        for (int i = 0; i < 10; i++) {
            (new Thread(new MysqlThread(context))).start();
        }
    }

}
