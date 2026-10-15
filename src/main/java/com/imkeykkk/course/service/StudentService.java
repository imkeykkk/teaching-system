package com.imkeykkk.course.service;

import com.imkeykkk.course.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudentList();

    Student getStudentById(Long id);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Long id);
}