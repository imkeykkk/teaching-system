package com.imkeykkk.course.controller;

import com.imkeykkk.course.common.Result;
import com.imkeykkk.course.entity.Question;
import com.imkeykkk.course.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping
    public Result<List<Question>> getQuestionList(){
        return Result.success(questionService.getQuestionsList());
    }

    @GetMapping("/{id}")
    public Result<Question> getQuestionById(@PathVariable Long id){
        return Result.success(questionService.getQuestionById(id));
    }

    @PostMapping
    public Result<String> addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return Result.success("新增成功");
    }

    @PutMapping("/{id}")
    public Result<String> updateQuestion(@PathVariable Long id,@RequestBody Question question){
        question.setId(id);
        questionService.updateQuestion(question);
        return Result.success("更新成功");
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestion(id);
        return Result.success("删除成功");
    }
}
