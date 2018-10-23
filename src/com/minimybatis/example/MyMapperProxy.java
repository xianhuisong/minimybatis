package com.minimybatis.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyMapperProxy implements InvocationHandler {

    private MySqlSession sqlSessionl;

    public MyMapperProxy() {
    }

    public MyMapperProxy(MySqlSession sqlSessionl) {
        this.sqlSessionl = sqlSessionl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String mapperClass = method.getDeclaringClass().getName();
        if (StudentMapperXML.namespace.equals(mapperClass)) {

            String methodName = method.getName();
            String originSql = StudentMapperXML.getMethodSQL(methodName);
            String formatedSql = String.format(originSql, args[0]);
            return sqlSessionl.selectOne(formatedSql);


        }

        return null;
    }
}
