package com.nwx.job.quartz.service.impl;

import com.nwx.job.quartz.service.TaskJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @DESC: 业务操作
 * @Author： Neil
 * @DATE: 2019/1/24 20:26
 */
@Service("taskJobService")
public class TaskJobServiceImpl implements TaskJobService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Map<String, Object> findById(String userId) {

        StringBuffer sql = new StringBuffer();
        sql.append("select * from sys_user t where t.user_id = 'zyuc'");

        List<Map<String, Object>> users = this.jdbcTemplate.queryForList(sql.toString());

        return users.get(0);
    }
}
