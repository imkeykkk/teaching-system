package com.imkeykkk.course.controller;

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
    public List<Course> getCourseList(){
        return courseService.getCourseList();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @PostMapping
    public String addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return "新增成功";
    }

    @PutMapping("/{id}")
    public String updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        courseService.updateCourse(course);
        return "修改成功";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "删除成功";
    }
}
