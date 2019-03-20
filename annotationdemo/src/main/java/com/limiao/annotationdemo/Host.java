package com.limiao.annotationdemo;

/**
 * Created by miao on 2019/3/14.
 */
public enum  Host {

    Host_1("http://h1/"),Host_2("http://h2/"),Host_3("http://h3/");

    private String host;

    Host(String host) {
        this.host = host;
    }

    public String getHost(){
        return host;
    }



}
