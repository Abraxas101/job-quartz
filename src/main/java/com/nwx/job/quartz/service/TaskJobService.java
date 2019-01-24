package com.nwx.job.quartz.service;

import java.util.Map;

public interface TaskJobService {
    Map<String, Object> findById(String userId);
}
