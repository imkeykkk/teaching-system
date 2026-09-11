package com.imkeykkk.course.service;

import com.imkeykkk.course.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudentList();

    Student getById(Long id);

    void add(Student student);

    void update(Student student);

    void delete(Long id);
}