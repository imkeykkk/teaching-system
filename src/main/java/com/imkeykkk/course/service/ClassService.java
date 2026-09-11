package com.imkeykkk.course.service;

import com.imkeykkk.course.entity.Clazz;
import com.imkeykkk.course.entity.Student;

import java.util.List;

public interface ClassService {
    List<Clazz> getClassList();

    Clazz getById(Long id);

    void add(Clazz clazz);

    void update(Clazz clazz);

    void delete(Long id);

    void addStudentToClass(Long classId,Long studentId);

    List<Student> getStudentsByClassId(Long classId);


}
