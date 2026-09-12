package com.imkeykkk.course.controller;

import com.imkeykkk.course.entity.Question;
import com.imkeykkk.course.entity.QuestionList;
import com.imkeykkk.course.entity.QuestionListItem;
import com.imkeykkk.course.mapper.QuestionListItemMapper;
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
    public List<QuestionList> getQuestionList(){
        return questionListService.getQuestionList();
    }

    @GetMapping("/{id}")
    public QuestionList getQuestionListById(@PathVariable Long id){
        return questionListService.getQuestionListById(id);
    }

    @PostMapping
    public String addQuestionList(@RequestBody QuestionList questionList){
        questionListService.addQuestionList(questionList);
        return "新增成功";
    }

    @PutMapping("/{id}")
    public String updateQuestionList(@PathVariable Long id, @RequestBody QuestionList questionList){
        questionList.setId(id);
        questionListService.updateQuestionList(id,questionList);
        return "更新成功";
    }

    @DeleteMapping("/{id}")
    public String deleteQuestionList(@PathVariable Long id){
        questionListService.deleteQuestionListById(id);
        return "删除成功";
    }

    @PostMapping("/{questionListId}/questions/{questionId}")
    public String addQuestionToQuestionList(@PathVariable Long questionListId, @PathVariable Long questionId){
        questionListService.addQuestionToQuestionList(questionListId,questionId);
        return "新增题目到题单";
    }

    @GetMapping("/{questionListId}/questions")
    public List<Question> getQuestions(@PathVariable Long questionListId){
        return questionListService.getQuestionByQuestionListId(questionListId);
    }
}
