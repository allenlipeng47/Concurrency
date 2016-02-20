package com.pli.project.concurrency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by pli on 2/12/2016.
 */
public class InsertMysql {


    public static void main(String[] args) throws Exception{
        String[] springConfig  =
                {
                        "spring-config.xml"
                };

        ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
        DataSource dataSource = (DataSource)context.getBean("dataSource");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
        long curr = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            jdbcTemplate.update("insert into test values(" + i + ")");
            jdbcTemplate.getDataSource().getConnection().commit();
        }





        System.out.println(System.currentTimeMillis() - curr);

    }

}
