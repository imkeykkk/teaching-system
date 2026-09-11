package com.imkeykkk.course.service.impl;

import com.imkeykkk.course.entity.Clazz;
import com.imkeykkk.course.mapper.ClazzMapper;
import com.imkeykkk.course.service.ClazzService;
import com.imkeykkk.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public List<Clazz> list() {
        return clazzMapper.selectList(null);
    }

    @Override
    public Clazz getById(Long id) {
        return clazzMapper.selectById(id);
    }

    @Override
    public void add(Clazz clazz) {
        clazzMapper.insert(clazz);
    }

    @Override
    public void update(Clazz clazz) {
        clazzMapper.updateById(clazz);
    }

    @Override
    public void delete(Long id) {
        clazzMapper.deleteById(id);
    }
}
