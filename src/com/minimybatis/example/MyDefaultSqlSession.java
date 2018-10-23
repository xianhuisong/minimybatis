package com.minimybatis.example;

import java.lang.reflect.Proxy;

public class MyDefaultSqlSession implements MySqlSession {

    private MyExecutor executor = new MyBaseExecutor();

    @Override
    public <T> T selectOne(String var1) {
        return executor.query(var1);
    }

    @Override
    public <T> T getMapper(Class<T> interfaces) {
        return (T)Proxy.newProxyInstance(interfaces.getClassLoader(), new Class[]{interfaces}, new MyMapperProxy(this));
    }
}
