package com.example.demo.mapper;

import com.example.demo.entity.user;

import java.util.List;

public interface studentMapper {
    List<user> queryAll();
    user queryStudentById(int id);
    int insertStudent(user user);
    int updateStudent(user user);
}
