package com.minimybatis.example;

import java.util.HashMap;
import java.util.Map;

public class StudentMapperXML {

    public static final String namespace = "com.minimybatis.example.StudentMapper";

    private static Map<String, String> methodSqlMap = new HashMap<>();

    static {
        methodSqlMap.put("findStudentById", "select * from student where id =%s");
    }

    public static String getMethodSQL(String method) {
        return methodSqlMap.get(method);
    }

}
