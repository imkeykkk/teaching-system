package com.imkeykkk.course.service;

import com.imkeykkk.course.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourseList();

    Course getById(Long id);

    void add(Course course);

    void update(Course course);

    void delete(Long id);
}