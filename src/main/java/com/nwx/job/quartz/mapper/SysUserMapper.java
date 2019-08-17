package com.nwx.job.quartz.mapper;

import com.nwx.job.quartz.pojo.SysUser;

public interface SysUserMapper {

    SysUser findUserById(String userId);
}
