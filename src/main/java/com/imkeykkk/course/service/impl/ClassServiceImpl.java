package com.imkeykkk.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imkeykkk.course.entity.Clazz;
import com.imkeykkk.course.entity.Student;
import com.imkeykkk.course.entity.StudentClass;
import com.imkeykkk.course.mapper.ClassMapper;
import com.imkeykkk.course.mapper.StudentClassMapper;
import com.imkeykkk.course.mapper.StudentMapper;
import com.imkeykkk.course.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private StudentClassMapper studentClassMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Clazz> list() {
        return classMapper.selectList(null);
    }

    @Override
    public Clazz getById(Long id) {
        return classMapper.selectById(id);
    }

    @Override
    public void add(Clazz clazz) {
        classMapper.insert(clazz);
    }

    @Override
    public void update(Clazz clazz) {
        classMapper.updateById(clazz);
    }

    @Override
    public void delete(Long id) {
        classMapper.deleteById(id);
    }

    @Override
    public void addStudentToClass(Long classId, Long studentId) {
        StudentClass studentClass = new StudentClass();
        studentClass.setClassId(classId);
        studentClass.setStudentId(studentId);
        studentClass.setStatus(0);
        studentClassMapper.insert(studentClass);
    }

    @Override
    public List<Student> getStudentsByClassId(Long classId) {
        // 1. 查关联表，拿到所有student_id
        QueryWrapper<StudentClass> wrapper = new QueryWrapper<>();
        wrapper.eq("class_id", classId);
        List<StudentClass> relations = studentClassMapper.selectList(wrapper);

        if (relations.isEmpty()) {
            return new ArrayList<>();
        }

        // 2. 取出所有student_id
        List<Long> studentIds = relations.stream()
                .map(StudentClass::getStudentId)
                .collect(Collectors.toList());

        // 3. 根据id列表查学生
        return studentMapper.selectBatchIds(studentIds);
    }


}
