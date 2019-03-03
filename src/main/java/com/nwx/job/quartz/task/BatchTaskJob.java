package com.nwx.job.quartz.task;

import com.nwx.job.quartz.utils.ListUtils;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version : V1.0
 * @Description: 使用多线程分批处理数据
 * @Auther: Neil
 * @Date: 2019/3/3 14:26
 */
@Component
public class BatchTaskJob {

    private static Logger logger = Logger.getLogger(BatchTaskJob.class);

    @Scheduled(cron = "0 0/3 * * * ?")
    protected void execute(){

        logger.info("批处理线程开始执行........");
        // 1、初始化数据
        List<Map<String,Object>> datas = this.initData();
        // 2、定义每个线程分批处理的数据大小
        int pageSize = 2;
        //3、计算每个线程需要分配处理的数据
        List<List<Map<String,Object>>> splitList = ListUtils.splitList(datas, pageSize);

        for (int i = 0; i < splitList.size(); i++) {
            List<Map<String,Object>> subList = splitList.get(i);
            //4、进行分批数据处理
            ThreadJob job = new ThreadJob(subList);
            Thread thread = new Thread(job, "线程"+i);
            thread.start();
        }
    }

    public static List<Map<String,Object>> initData(){
        List<Map<String,Object>> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String,Object> item = new HashMap<>();
            item.put("name", "name"+i);
            item.put("id", i+"");
            datas.add(item);
        }
        return datas;
    }

    public static void main(String[] args) {
        BatchTaskJob batchTaskJob = new BatchTaskJob();
        batchTaskJob.execute();
    }
}

/**
 * @Author Neil
 * @Description 线程的执行器
 * @Date 2019/3/3 14:55
 * @Param 
 * @return 
 **/
class ThreadJob implements Runnable{

    private static Logger logger = Logger.getLogger(ThreadJob.class);

    private List<Map<String,Object>> subList;
    
    public ThreadJob(List<Map<String,Object>> subList){
        this.subList = subList;
    }

    @Override
    public void run() {
        for (Map<String,Object> item : this.subList){
            logger.info("线程"+Thread.currentThread().getName()+"执行数据："+item.toString());
        }
    }
}