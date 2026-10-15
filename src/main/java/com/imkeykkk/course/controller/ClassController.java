package com.imkeykkk.course.controller;

import com.imkeykkk.course.entity.Clazz;
import com.imkeykkk.course.entity.Student;
import com.imkeykkk.course.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping
    public List<Clazz> getClassList() {
        return classService.getClassList();
    }

    @GetMapping("/{id}")
    public Clazz getClassById(@PathVariable Long id) {
        return classService.getClassById(id);
    }

    @PostMapping
    public String addClass(@RequestBody Clazz clazz) {
        classService.addClass(clazz);
        return "新增成功";
    }

    @PutMapping("/{id}")
    public String updateClass(@PathVariable Long id, @RequestBody Clazz clazz) {
        clazz.setId(id);
        classService.updateClass(clazz);
        return "修改成功";
    }

    @DeleteMapping("/{id}")
    public String deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return "删除成功";
    }

    @PostMapping("/{classId}/students/{studentId}")
    public String addStudentToClass(@PathVariable Long classId, @PathVariable Long studentId) {
        classService.addStudentToClass(classId, studentId);
        return "加入班级成功";
    }

    @GetMapping("/{classId}/students")
    public List<Student> getStudentsByClassId(@PathVariable Long classId) {

        return classService.getStudentsByClassId(classId);
    }
    
    
}
