package com.imkeykkk.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imkeykkk.course.entity.ChapterQuestion;
import com.imkeykkk.course.entity.CourseChapter;
import com.imkeykkk.course.entity.Question;
import com.imkeykkk.course.mapper.ChapterQuestionMapper;
import com.imkeykkk.course.mapper.CourseChapterMapper;
import com.imkeykkk.course.mapper.QuestionMapper;
import com.imkeykkk.course.service.CourseChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseChapterServiceImpl implements CourseChapterService {

    @Autowired
    CourseChapterMapper courseChapterMapper;

    @Autowired
    private ChapterQuestionMapper chapterQuestionMapper;

    @Autowired
    private QuestionMapper questionMapper;

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

    @Override
    public List<Question> getQuestionsByChapterId(Long chapterId) {
        QueryWrapper<ChapterQuestion> wrapper = new QueryWrapper<>();
        wrapper.eq("chapter_id", chapterId);
        List<ChapterQuestion> relations = chapterQuestionMapper.selectList(wrapper);

        if (relations.isEmpty()) {
            return new ArrayList<>();
        }

        List<Long> questionIds = relations.stream()
                .map(ChapterQuestion::getQuestionId)
                .collect(Collectors.toList());

        return questionMapper.selectBatchIds(questionIds);
    }

    @Override
    public void addQuestionToChapter(Long chapterId, Long questionId) {
        ChapterQuestion cq = new ChapterQuestion();
        cq.setChapterId(chapterId);
        cq.setQuestionId(questionId);
        chapterQuestionMapper.insert(cq);
    }
}
