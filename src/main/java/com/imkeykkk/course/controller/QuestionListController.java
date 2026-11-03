package com.imkeykkk.course.controller;

import com.imkeykkk.course.common.Result;
import com.imkeykkk.course.entity.Question;
import com.imkeykkk.course.entity.QuestionList;
import com.imkeykkk.course.service.QuestionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question-lists")
public class QuestionListController {
    @Autowired
    QuestionListService questionListService;



    @GetMapping
    public Result<List<QuestionList>> getQuestionList(){
        return Result.success(questionListService.getQuestionList());
    }

    @GetMapping("/{id}")
    public Result<QuestionList> getQuestionListById(@PathVariable Long id){
        return Result.success(questionListService.getQuestionListById(id));
    }

    @PostMapping
    public Result<String> addQuestionList(@RequestBody QuestionList questionList){
        questionListService.addQuestionList(questionList);
        return Result.success("新增成功");
    }

    @PutMapping("/{id}")
    public Result<String> updateQuestionList(@PathVariable Long id, @RequestBody QuestionList questionList){
        questionList.setId(id);
        questionListService.updateQuestionList(id,questionList);
        return Result.success("更新成功");
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteQuestionList(@PathVariable Long id){
        questionListService.deleteQuestionListById(id);
        return Result.success("删除成功");
    }

    @PostMapping("/{questionListId}/questions/{questionId}")
    public Result<String> addQuestionToQuestionList(@PathVariable Long questionListId, @PathVariable Long questionId){
        questionListService.addQuestionToQuestionList(questionListId,questionId);
        return Result.success("新增题目到题单");
    }

    @GetMapping("/{questionListId}/questions")
    public Result<List<Question>> getQuestionsByQuestionListId(@PathVariable Long questionListId){
        return Result.success(questionListService.getQuestionsByQuestionListId(questionListId));
    }
}
