package com.imkeykkk.course.controller;

import com.imkeykkk.course.common.Result;
import com.imkeykkk.course.entity.CourseChapter;
import com.imkeykkk.course.entity.Question;
import com.imkeykkk.course.service.CourseChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/{courseId}/chapters")
public class CourseChapterController {

    @Autowired
    private CourseChapterService courseChapterService;

    @GetMapping
    public Result<List<CourseChapter>> getChapterList(@PathVariable Long courseId) {
        return Result.success(courseChapterService.getChaptersByCourseId(courseId));
    }

    @GetMapping("/{id}")
    public Result<CourseChapter> getChapter(@PathVariable Long courseId, @PathVariable Long id) {
        return Result.success(courseChapterService.getChapterById(id));
    }

    @PostMapping
    public Result<String> addChapter(@PathVariable Long courseId, @RequestBody CourseChapter chapter) {
        chapter.setCourseId(courseId);
        courseChapterService.addChapter(chapter);
        return Result.success("新增成功");
    }

    @PutMapping("/{id}")
    public Result<String> updateChapter(@PathVariable Long courseId, @PathVariable Long id, @RequestBody CourseChapter chapter) {
        chapter.setId(id);
        chapter.setCourseId(courseId);
        courseChapterService.updateChapter(chapter);
        return Result.success("修改成功");
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteChapter(@PathVariable Long courseId, @PathVariable Long id) {
        courseChapterService.deleteChapter(id);
        return Result.success("删除成功");
    }

    @PostMapping("/{chapterId}/questions/{questionId}")
    public Result<String> addQuestionToChapter(@PathVariable Long courseId, @PathVariable Long chapterId, @PathVariable Long questionId) {
        courseChapterService.addQuestionToChapter(chapterId, questionId);
        return Result.success("添加题目成功");
    }

    @GetMapping("/{chapterId}/questions")
    public Result<List<Question>> getQuestionsByChapterId(@PathVariable Long courseId, @PathVariable Long chapterId) {
        return Result.success(courseChapterService.getQuestionsByChapterId(chapterId));
    }
}