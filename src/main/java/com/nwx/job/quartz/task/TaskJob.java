package com.nwx.job.quartz.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @DESC: 任务执行器
 * @Author： Neil
 * @DATE: 2019/1/24 18:58
 */

@Component
public class TaskJob {

    @Scheduled(cron = "0 0/1 * * * ?")
    protected void execute(){

        System.out.println("TaskJob start run。。。。。" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
