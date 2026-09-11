package com.imkeykkk.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imkeykkk.course.entity.Student;
import com.imkeykkk.course.entity.User;
import com.imkeykkk.course.mapper.StudentMapper;
import com.imkeykkk.course.mapper.UserMapper;
import com.imkeykkk.course.service.StudentService;
import com.imkeykkk.course.service.UserService;

import com.imkeykkk.course.util.PinyinUtil;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<Student> getStudentList() {
        return studentMapper.selectList(null);
    }

    @Override
    public Student getById(Long id) {
        return studentMapper.selectById(id);
    }

    @Override
    @Transactional//事务注解，保证全部成功或全部回滚，避免在多个操作中部分操作成功部分失败导致数据不一致
    public void add(Student student) {

        // 1. 生成用户名和密码
        String pinyin = PinyinUtil.toPinyin(student.getName());
        String username = generateUniqueUsername(pinyin);
        String rawPassword = pinyin + "123@";//默认Miami

        //创建学生时自动创建登录账号
        User user = new User();
        user.setUsername(username);
        user.setPassword(rawPassword);
        user.setRealName(student.getName());
        user.setRole(1);//1=学生
        user.setOrgId(student.getOrgId());
        userMapper.insert(user);//插入登录用户

        student.setUserId(user.getId());


        studentMapper.insert(student);//插入学生记录
    }

    private String generateUniqueUsername(String base) {//处理重名情况，在重名后加递增数字
        String username = base;
        int suffix = 1;
        while (userMapper.selectCount(
                new QueryWrapper<User>().eq("username", username)) > 0) {
            username = base + suffix;
            suffix++;
        }
        return username;
    }

    @Override
    public void update(Student student) {
        studentMapper.updateById(student);//updateById 的核心逻辑是‌依赖主键 ID 作为 WHERE 条件来定位唯一记录
    }

    @Override
    public void delete(Long id) {
        studentMapper.deleteById(id);
    }
}
