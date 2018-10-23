package com.minimybatis.example;

public class Test {

    public static void main(String[] args) {
        MySqlSession session = new MyDefaultSqlSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = studentMapper.findStudentById(1);
        System.out.println(student);
    }
}
