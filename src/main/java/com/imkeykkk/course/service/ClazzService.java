package com.imkeykkk.course.service;

import com.imkeykkk.course.entity.Clazz;

import java.util.List;

public interface ClazzService {
    List<Clazz> list();

    Clazz getById(Long id);

    void add(Clazz clazz);

    void update(Clazz clazz);

    void delete(Long id);
}
