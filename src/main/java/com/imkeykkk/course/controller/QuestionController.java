package com.imkeykkk.course.controller;

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
    public List<Question> getQuestionList(){
        return questionService.getQuestionsList();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id){
        return questionService.getQuestionById(id);
    }

    @PostMapping
    public String addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return "新增成功";
    }

    @PutMapping("/{id}")
    public String updateQuestion(@PathVariable Long id,@RequestBody Question question){
        question.setId(id);
        questionService.updateQuestion(question);
        return "更新成功";
    }

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestion(id);
        return "删除成功";
    }
}
