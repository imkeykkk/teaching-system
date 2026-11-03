package com.imkeykkk.course.controller;

import com.imkeykkk.course.common.Result;
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
    public Result<List<Contest>> getContestList(){
        return Result.success(contestService.getContestsList());
    }

    @GetMapping("/{id}")
    public Result<Contest> getContest(@PathVariable Long id){
        return Result.success(contestService.getContestById(id));
    }

    @PostMapping
    public Result<String> addContest(@RequestBody Contest contest){
        contestService.addContest(contest);
        return Result.success("新增成功");
    }

    @PutMapping("/{id}")
    public Result<String> updateContest(@PathVariable Long id, @RequestBody Contest contest){
        contest.setId(id);
        contestService.updateContest(contest);
        return Result.success("更新成功");
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteContest(@PathVariable Long id){
        contestService.deleteContest(id);
        return Result.success("删除成功");
    }

    @PostMapping("/{contestId}/questions/{questionId}")
    public Result<String> addQuestionToContest(@PathVariable Long contestId, @PathVariable Long questionId){
        contestService.addQuestionToContest(contestId, questionId);
        return Result.success("添加题目成功");
    }

    @GetMapping("/{contestId}/questions")
    public Result<List<Question>> getQuestionListByContestId(@PathVariable Long contestId){
        return Result.success(contestService.getQuestionsByContestId(contestId));
    }

}
