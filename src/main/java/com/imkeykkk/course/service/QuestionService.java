package com.imkeykkk.course.service;

import com.imkeykkk.course.entity.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionsList();

    Question getQuestionById(Long id);

    void addQuestion(Question question);

    void updateQuestion(Question question);

    void deleteQuestion(Long id);
}
