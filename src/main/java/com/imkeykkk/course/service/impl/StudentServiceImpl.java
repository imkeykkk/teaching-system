package com.imkeykkk.course.service.impl;

import com.imkeykkk.course.entity.Student;
import com.imkeykkk.course.mapper.StudentMapper;
import com.imkeykkk.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> list() {
        return studentMapper.selectList(null);
    }

    @Override
    public Student getById(Long id) {
        return studentMapper.selectById(id);
    }

    @Override
    public void add(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void update(Student student) {
        studentMapper.updateById(student);
    }

    @Override
    public void delete(Long id) {
        studentMapper.deleteById(id);
    }
}
