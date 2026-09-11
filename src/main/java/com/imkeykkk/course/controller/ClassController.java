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
    public List<Clazz> list() {
        return classService.list();
    }

    @GetMapping("/{id}")
    public Clazz getById(@PathVariable Long id) {
        return classService.getById(id);
    }

    @PostMapping
    public String add(@RequestBody Clazz clazz) {
        classService.add(clazz);
        return "新增成功";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Clazz clazz) {
        clazz.setId(id);
        classService.update(clazz);
        return "修改成功";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        classService.delete(id);
        return "删除成功";
    }

    @PostMapping("/{classId}/students/{studentId}")
    public String addStudent(@PathVariable Long classId, @PathVariable Long studentId) {
        classService.addStudentToClass(classId, studentId);
        return "加入班级成功";
    }

    @GetMapping("/{classId}/students")
    public List<Student> getStudents(@PathVariable Long classId) {
        return classService.getStudentsByClassId(classId);
    }
    
    
}
