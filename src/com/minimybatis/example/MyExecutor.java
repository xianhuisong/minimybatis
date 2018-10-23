package com.minimybatis.example;

public interface MyExecutor {

    public <T> T query(String statement);

}
