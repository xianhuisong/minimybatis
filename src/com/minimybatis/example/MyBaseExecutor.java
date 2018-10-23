package com.minimybatis.example;

import java.sql.*;

public class MyBaseExecutor implements MyExecutor {

    private static final String CONNECTIONURL = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    @Override
    public <T> T query(String statement) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = DriverManager.getConnection(CONNECTIONURL, USERNAME, PASSWORD);
            String sql = statement;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Student student = null;

            if (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setSex(resultSet.getInt("sex"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setAddress(resultSet.getString("address"));
            }
            return (T) student;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
