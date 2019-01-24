package com.nwx.job.quartz.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.Logger;

/**
 * @DESC: 主方法
 * @Author： Neil
 * @DATE: 2019/1/24 19:07
 */
public class AppMain {

    private static Logger logger = Logger.getLogger(AppMain.class);

    public static void main(String[] args) {

        logger.info("app run 。。。。");
        new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }
}
