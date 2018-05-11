package com.collect.dto;

import java.io.Serializable;

/**
 * Created by nina_nyang on 2018/4/28.
 */
public class UserInfoDTO implements Serializable{

    private static final long serialVersionUID = 2816897889189823900L;

    //登录名
    private String userName;
    //密码
    private String password;
    //新密码1
    private String newPassword1;
    //新密码2
    private String newPassword2;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword1() {
        return newPassword1;
    }

    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }
}
