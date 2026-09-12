package com.imkeykkk.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imkeykkk.course.entity.Contest;
import com.imkeykkk.course.entity.ContestQuestion;
import com.imkeykkk.course.entity.Question;
import com.imkeykkk.course.mapper.ContestMapper;
import com.imkeykkk.course.mapper.ContestQuestionMapper;
import com.imkeykkk.course.mapper.QuestionMapper;
import com.imkeykkk.course.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContestServiceImpl implements ContestService {

    @Autowired
    private ContestMapper contestMapper;

    @Autowired
    private ContestQuestionMapper contestQuestionMapper;
    @Autowired
    private QuestionMapper questionMapper;


    @Override
    public List<Contest> getContestsList() {
        return contestMapper.selectList(null);
    }

    @Override
    public Contest getContestById(Long id) {
        return contestMapper.selectById(id);
    }

    @Override
    public void addContest(Contest contest) {
        contestMapper.insert(contest);
    }

    @Override
    public void updateContest(Contest contest) {
        contestMapper.updateById(contest);
    }

    @Override
    public void deleteContest(Long id) {
        contestMapper.deleteById(id);
    }

    @Override
    public void addQuestionToContest(Long contestId, Long questionId) {
        ContestQuestion contestQuestion = new ContestQuestion();
        contestQuestion.setContestId(contestId);
        contestQuestion.setQuestionId(questionId);
        contestQuestionMapper.insert(contestQuestion);
    }

    @Override
    public List<Question> getQuestionsByContestId(Long contestId) {
        QueryWrapper<ContestQuestion> wrapper = new QueryWrapper<>();
        wrapper.eq("contest_id",contestId);
        List<ContestQuestion> relations = contestQuestionMapper.selectList(wrapper);

        if(relations.isEmpty()){
            return new ArrayList<>();
        }

        List<Long> questionIds = relations.stream()
                .map(ContestQuestion::getContestId)
                .collect(Collectors.toList());

        return questionMapper.selectBatchIds(questionIds);
    }
}
