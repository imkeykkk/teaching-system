package com.imkeykkk.course.service.impl;

import com.imkeykkk.course.entity.Course;
import com.imkeykkk.course.mapper.CourseMapper;
import com.imkeykkk.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> getCourseList() {
        return courseMapper.selectList(null);
    }

    @Override
    public Course getById(Long id) {
        return courseMapper.selectById(id);
    }

    @Override
    public void add(Course course) {
        courseMapper.insert(course);
    }

    @Override
    public void update(Course course) {
        courseMapper.updateById(course);
    }

    @Override
    public void delete(Long id) {
        courseMapper.deleteById(id);
    }
}
