package com.nwx.job.quartz.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @DESC: 主方法
 * @Author： Neil
 * @DATE: 2019/1/24 19:07
 */
public class AppMain {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }
}
