package com.nwx.job.quartz.pojo;

import java.io.Serializable;

/**
 * <Description>  <br>
 *
 * @author Neil<br>
 * @version 1.0<br>
 * @createDate 2019/08/17 10:19 <br>
 * @see com.nwx.job.quartz.pojo <br>
 */
public class SysUser implements Serializable {

    private String userId;
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
