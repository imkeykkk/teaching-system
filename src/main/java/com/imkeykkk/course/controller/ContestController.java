package com.imkeykkk.course.controller;

import com.imkeykkk.course.entity.Contest;
import com.imkeykkk.course.entity.Question;
import com.imkeykkk.course.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contests")
public class ContestController {

    @Autowired
    private ContestService contestService;

    @GetMapping
    public List<Contest> getContestList(){
        return contestService.getContestsList();
    }

    @GetMapping("/{id}")
    public Contest getContest(@PathVariable Long id){
        return contestService.getContestById(id);
    }

    @PostMapping
    public String addContest(@RequestBody Contest contest){
        contestService.addContest(contest);
        return "新增成功";
    }

    @PutMapping("/{id}")
    public String updateContest(@PathVariable Long id, @RequestBody Contest contest){
        contest.setId(id);
        contestService.updateContest(contest);
        return "更新成功";
    }

    @DeleteMapping("/{id}")
    public String deleteContest(@PathVariable Long id){
        contestService.deleteContest(id);
        return "删除成功";
    }

    @PostMapping("/{contestId}/questions/{questionId}")
    public String addQuestion(@PathVariable Long contestId, @PathVariable Long questionId){
        contestService.addQuestionToContest(contestId, questionId);
        return "添加题目成功";
    }

    @GetMapping("/{contestId}/questions")
    public List<Question> getQuestionList(@PathVariable Long contestId){
        return contestService.getQuestionsByContestId(contestId);
    }

}
