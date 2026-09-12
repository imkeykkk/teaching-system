package com.imkeykkk.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imkeykkk.course.entity.Question;
import com.imkeykkk.course.entity.QuestionList;
import com.imkeykkk.course.entity.QuestionListItem;
import com.imkeykkk.course.mapper.QuestionListItemMapper;
import com.imkeykkk.course.mapper.QuestionListMapper;
import com.imkeykkk.course.mapper.QuestionMapper;
import com.imkeykkk.course.service.QuestionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionListServiceImpl implements QuestionListService {

    @Autowired
    private QuestionListMapper questionListMapper;

    @Autowired
    private QuestionListItemMapper questionListItemMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<QuestionList> getQuestionList() {
        return questionListMapper.selectList(null);
    }

    @Override
    public QuestionList getQuestionListById(Long id) {
        return questionListMapper.selectById(id);
    }

    @Override
    public void addQuestionList(QuestionList questionList) {
        questionListMapper.insert(questionList);
    }

    @Override
    public void updateQuestionList(Long id, QuestionList questionList) {
        questionList.setId(id);
        questionListMapper.updateById(questionList);
    }

    @Override
    public void deleteQuestionListById(Long id) {
        questionListMapper.deleteById(id);
    }

    @Override
    public void addQuestionToQuestionList(Long questionListId, Long questionId) {
        QuestionListItem item = new QuestionListItem();
        item.setQuestionId(questionId);
        item.setQuestionListId(questionListId);
        questionListItemMapper.insert(item);
    }

    @Override
    public List<Question> getQuestionByQuestionListId(Long questionListId) {
        QueryWrapper<QuestionListItem> wrapper = new QueryWrapper<>();
        wrapper.eq("question_list_id", questionListId);

        List<QuestionListItem> relations = questionListItemMapper.selectList(wrapper);

        if(relations.isEmpty()){
            return new ArrayList<>();
        }

        List<Long> questionsId = relations.stream()
                .map(QuestionListItem::getQuestionId)
                .collect(Collectors.toList());

        return  questionMapper.selectBatchIds(questionsId);
    }
}
