package com.nwx.job.quartz;

import com.nwx.job.quartz.mapper.SysUserMapper;
import com.nwx.job.quartz.pojo.SysUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <Description>  <br>
 *
 * @author Neil<br>
 * @version 1.0<br>
 * @createDate 2019/08/17 10:33 <br>
 * @see com.nwx.job.quartz <br>
 */
public class AppMainTest {

    private ApplicationContext applicationContext;

    @Before
    public void setup() throws Exception {
        applicationContext = new
                ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }


    @Test
    public void testFindUserById() throws Exception {
        // 通过配置资源对象获取 userDAO 对象
        SysUserMapper sysUserMapper = (SysUserMapper) applicationContext.getBean("sysUserMapper");
        // 调用 UserDAO 的方法
        SysUser user = sysUserMapper.findUserById("1");
        // 输出用户信息
        System.out.println(user.toString());
    }
}
