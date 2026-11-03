package com.imkeykkk.course.controller;

import com.imkeykkk.course.common.Result;
import com.imkeykkk.course.entity.Course;
import com.imkeykkk.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping
    public Result<List<Course>> getCourseList(){
        return Result.success(courseService.getCourseList());
    }

    @GetMapping("/{id}")
    public Result<Course> getCourseById(@PathVariable Long id){
        return Result.success(courseService.getCourseById(id));
    }

    @PostMapping
    public Result<String> addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return Result.success("新增成功");
    }

    @PutMapping("/{id}")
    public Result<String> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        courseService.updateCourse(course);
        return Result.success("修改成功");
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return Result.success("删除成功");
    }
}
