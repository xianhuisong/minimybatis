package com.minimybatis.example;

public interface StudentMapper {

    public Student findStudentById(int id);

    public void insertStudent(Student student);
}
