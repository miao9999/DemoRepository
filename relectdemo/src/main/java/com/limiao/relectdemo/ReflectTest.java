package com.limiao.relectdemo;


import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class ReflectTest extends Parent implements Serializable{

    private String name1;

    public ReflectTest(String name, String age) {
        super(name, age);
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        ReflectTest reflectTest = new ReflectTest();
//        String className = reflectTest.getClass().getName().toString();
//        System.out.println(className);

        // 获取对象的父类和实现的接口
        Class clazz = Class.forName("com.limiao.relectdemo.ReflectTest");
        // 获取父类
        Class parentClass = clazz.getSuperclass();
        System.out.println(parentClass.getName());
        // 获取所有的接口
        Class[] inens = clazz.getInterfaces();
        System.out.println(inens.length);
        for (int i = 0; i < inens.length; i++) {
            System.out.println(inens[i].getName());
        }

        // 获取实现的接口或是父类的属性
        Field[] fields = clazz.getFields();

        System.out.println("field length : " + fields.length);
        for (int i = 0; i < fields.length; i++) {
            // 获取权限修饰符
            int mo = fields[i].getModifiers();
            String priv = Modifier.toString(mo);

            // 属性类型
            Class type1 = fields[i].getType();
            System.out.println("----" +priv + " " + type1.getName() + " " + fields[i].getName());
        }

        //动态代理////////////////////////////

         MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        Subject bind = (Subject) myInvocationHandler.bind(new RealSubject());
        String info = bind.say("name",20);
        System.out.println(info);
    }


}


///////////////动态代理/////////////////////////////

interface Subject{
    String say(String name,int age);
}

class RealSubject implements Subject{

    @Override
    public String say(String name, int age) {
        return name + age;
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object mObject = null;


    public Object bind(Object object){
        mObject = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object object = method.invoke(mObject,objects);
        return object;
    }
}





