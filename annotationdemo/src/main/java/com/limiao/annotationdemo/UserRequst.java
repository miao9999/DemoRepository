package com.limiao.annotationdemo;

/**
 * Created by miao on 2019/3/14.
 */
@RequestParamUrl(url = "aaa/user.json",HOST = Host.Host_2,isCache = false)
public class UserRequst {

    @RequestParameKey(key = "username_key")
    String username;
    @RequestParameKey(key = "password_key")
    String password;
}
