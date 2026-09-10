package com.imkeykkk.course.controller;

import com.imkeykkk.course.entity.Student;
import com.imkeykkk.course.mapper.StudentMapper;
import com.imkeykkk.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")//也是用来处理请求的，类级别定义基础路径，里面的方法还要用method属性来具体指定，否则默认匹配所有请求方法
//也可以用来注解方法，如@PutMapping("/students/{id}")等价于@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
public class StudentController {
    @Autowired
    StudentService studentService;

    //在 RESTful 风格开发中，‌同一个 URL（资源路径）可以通过不同的 HTTP 请求方法（GET, POST, PUT, DELETE 等）映射到后端不同的处理函数‌，从而执行完全不同的业务逻辑

    @GetMapping//方法上没有指定子路径时，直接响应类路径
    public List<Student> list() {
        return studentService.list();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @PostMapping//Post请求通常用于创建‌新资源，方法上没有指定子路径时，直接响应类路径
    public String add(@RequestBody Student student) {
        studentService.add(student);
        return "新增成功";
    }

    @PutMapping("/{id}")//PUT 请求通常用于‌更新现有的资源，并且是全量更新，部分更新时用@PatchMapping
    //且PUT 是‌幂等‌的（Idempotent），即多次执行相同的 PUT 请求，服务器的状态应该是一致的（资源被更新为相同的状态）
    public String update(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        studentService.update(student);
        return "修改成功";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return "删除成功";
    }

}
