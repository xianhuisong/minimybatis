package com.minimybatis.example;

public interface MySqlSession {

    <T> T selectOne(String var1);

    <T> T getMapper(Class<T> var1);

}
