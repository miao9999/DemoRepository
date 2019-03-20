package com.limiao.annotationdemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by miao on 2019/3/14.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestParamUrl {
    // url
    String url();

    // 端口
    Host HOST() default Host.Host_1;

    // 是否缓存
    boolean isCache() default true;
}

