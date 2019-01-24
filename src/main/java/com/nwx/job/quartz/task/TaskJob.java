package com.nwx.job.quartz.task;

import com.nwx.job.quartz.service.TaskJobService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @DESC: 任务执行器
 * @Author： Neil
 * @DATE: 2019/1/24 18:58
 */

@Component
public class TaskJob {

    private static Logger logger = Logger.getLogger(TaskJob.class);

    @Autowired
    private TaskJobService taskJobService;

    @Scheduled(cron = "0 0/3 * * * ?")
    protected void execute(){

        Map<String,Object> user = taskJobService.findById("zyuc");

        logger.info("user info :" + user.toString());
    }
}
