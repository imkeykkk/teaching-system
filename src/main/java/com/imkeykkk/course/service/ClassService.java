package com.imkeykkk.course.service;

import com.imkeykkk.course.entity.Clazz;
import com.imkeykkk.course.entity.Student;

import java.util.List;

public interface ClassService {
    List<Clazz> getClassList();

    Clazz getClassById(Long id);

    void addClass(Clazz clazz);

    void updateClass(Clazz clazz);

    void deleteClass(Long id);

    void addStudentToClass(Long classId,Long studentId);

    List<Student> getStudentsByClassId(Long classId);


}
