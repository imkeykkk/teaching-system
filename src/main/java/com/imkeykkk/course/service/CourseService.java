package com.imkeykkk.course.service;

import com.imkeykkk.course.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourseList();

    Course getCourseById(Long id);

    void addCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(Long id);
}