package com.limiao.annotationdemo;

import android.util.Log;

import java.lang.reflect.Field;
import java.sql.Struct;

/**
 * Created by miao on 2019/3/14.
 */
public class RequestParam {
    public RequestParam() {
    }


    public static String requestParam(Class<?> clazz,Object object) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();

        // 存放请求参数
        StringBuilder request = new StringBuilder();

        // 通过 Class 的对象，获取该类上对应的注解的类(该注解修饰的是类用 clazz)
        RequestParamUrl requestParamUrl = clazz.getAnnotation(RequestParamUrl.class);

        boolean isCache = requestParamUrl.isCache();
        // 取出注解里的值，拼接 url
        request.append(requestParamUrl.HOST().getHost());
        request.append(requestParamUrl.url());
        request.append("?");

        Log.e("RequestParam == ","host + url:" + request.toString());

        // 遍历类中的所有属性
        for (Field field : fields) {
            //通过 field 的对象，获取该类上对应的注解的类(该注解修饰的是属性用 clazz)
            RequestParameKey requestParameKey = field.getAnnotation(RequestParameKey.class);

            if (requestParameKey != null) {
                // 取出注解中的值
                String key = requestParameKey.key();
                // 根据类对象从 field 中取出该属性对就的值
                String value = (String) field.get(object);

                // 把参数拼接到 url 中
                request.append(key);
                request.append("=");
                request.append(value);
                request.append("&");
            }
        }

        // 删除最后一个 & 符号
        request.deleteCharAt(request.length() -1);

        Log.e("RequestParam","host + url + params: "  + request.toString());
        return request.toString();




    }
}
