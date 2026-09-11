package com.imkeykkk.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imkeykkk.course.entity.CourseChapter;
import com.imkeykkk.course.mapper.CourseChapterMapper;
import com.imkeykkk.course.service.CourseChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseChapterServiceImpl implements CourseChapterService {

    @Autowired
    CourseChapterMapper courseChapterMapper;

    @Override
    public List<CourseChapter> getChaptersByCourseId(Long courseId) {
        QueryWrapper<CourseChapter> wrapper  = new QueryWrapper<>();
        wrapper .eq("course_id",courseId);
        wrapper.orderByAsc("sort_order");
        return courseChapterMapper.selectList(wrapper );
    }

    @Override
    public CourseChapter getChapterById(Long id) {
        return courseChapterMapper.selectById(id);
    }

    @Override
    public void addChapter(CourseChapter chapter) {
        courseChapterMapper.insert(chapter);
    }

    @Override
    public void updateChapter(CourseChapter chapter) {
        courseChapterMapper.updateById(chapter);
    }

    @Override
    public void deleteChapter(Long id) {
        courseChapterMapper.deleteById(id);
    }
}
