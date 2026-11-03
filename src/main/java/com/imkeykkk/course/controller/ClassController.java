package com.imkeykkk.course.controller;

import com.imkeykkk.course.common.Result;
import com.imkeykkk.course.entity.Clazz;
import com.imkeykkk.course.entity.Student;
import com.imkeykkk.course.service.ClassService;
import com.imkeykkk.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private ClassService classService;
    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result<List<Clazz>> getClassList() {
        return Result.success(classService.getClassList());
    }

    @GetMapping("/{id}")
    public Result<Clazz> getClassById(@PathVariable Long id) {
        return Result.success(classService.getClassById(id));
    }

    @PostMapping
    public Result<String> addClass(@RequestBody Clazz clazz) {
        classService.addClass(clazz);
        return Result.success("新增成功");
    }

    @PutMapping("/{id}")
    public Result<String>  updateClass(@PathVariable Long id, @RequestBody Clazz clazz) {
        clazz.setId(id);
        classService.updateClass(clazz);
        return Result.success("修改成功");
    }

    @DeleteMapping("/{id}")
    public Result<String>  deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return Result.success("删除成功");
    }

    @PostMapping("/{classId}/students/{studentId}")
    public Result<String> addStudentToClass(@PathVariable Long classId, @PathVariable Long studentId) {
        classService.addStudentToClass(classId, studentId);
        return Result.success("加入班级成功");
    }

    @GetMapping("/{classId}/students")
    public Result<List<Student>> getStudentsByClassId(@PathVariable Long classId) {

        return Result.success(classService.getStudentsByClassId(classId));
    }
    
    
}
