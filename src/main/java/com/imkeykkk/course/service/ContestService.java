package com.imkeykkk.course.service;

import com.imkeykkk.course.entity.Contest;
import com.imkeykkk.course.entity.Question;

import java.util.List;

public interface ContestService {
    List<Contest> getContestsList();

    Contest getContestById(Long id);

    void addContest(Contest contest);

    void updateContest(Contest contest);

    void deleteContest(Long id);

    void addQuestionToContest(Long contestId, Long questionId);

    List<Question> getQuestionsByContestId(Long contestId);
}
