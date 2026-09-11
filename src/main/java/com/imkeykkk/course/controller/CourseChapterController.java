package com.imkeykkk.course.controller;

import com.imkeykkk.course.entity.CourseChapter;
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
    public List<CourseChapter> getChapterList(@PathVariable Long courseId) {
        return courseChapterService.getChaptersByCourseId(courseId);
    }

    @GetMapping("/{id}")
    public CourseChapter getChapter(@PathVariable Long courseId, @PathVariable Long id) {
        return courseChapterService.getChapterById(id);
    }

    @PostMapping
    public String addChapter(@PathVariable Long courseId, @RequestBody CourseChapter chapter) {
        chapter.setCourseId(courseId);
        courseChapterService.addChapter(chapter);
        return "新增成功";
    }

    @PutMapping("/{id}")
    public String updateChapter(@PathVariable Long courseId, @PathVariable Long id, @RequestBody CourseChapter chapter) {
        chapter.setId(id);
        chapter.setCourseId(courseId);
        courseChapterService.updateChapter(chapter);
        return "修改成功";
    }

    @DeleteMapping("/{id}")
    public String deleteChapter(@PathVariable Long courseId, @PathVariable Long id) {
        courseChapterService.deleteChapter(id);
        return "删除成功";
    }
}