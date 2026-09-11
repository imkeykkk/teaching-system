package com.imkeykkk.course.service.impl;

import com.imkeykkk.course.entity.Question;
import com.imkeykkk.course.mapper.QuestionMapper;
import com.imkeykkk.course.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Override
    public List<Question> getQuestionsList() {
        return questionMapper.selectList(null);
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionMapper.selectById(id);
    }

    @Override
    public void addQuestion(Question question) {
        questionMapper.insert(question);
    }

    @Override
    public void updateQuestion(Question question) {
        questionMapper.updateById(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionMapper.deleteById(id);
    }
}
