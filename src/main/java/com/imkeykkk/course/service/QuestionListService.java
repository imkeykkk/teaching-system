package com.imkeykkk.course.service;

import com.imkeykkk.course.entity.Question;
import com.imkeykkk.course.entity.QuestionList;

import java.util.List;

public interface QuestionListService {

    List<QuestionList> getQuestionList();

    QuestionList getQuestionListById(Long id);

    void addQuestionList(QuestionList questionList);

    void updateQuestionList(Long id, QuestionList questionList);

    void deleteQuestionListById(Long id);

    void addQuestionToQuestionList(Long questionListId, Long questionId);

    List<Question> getQuestionByQuestionListId(Long id);
}
