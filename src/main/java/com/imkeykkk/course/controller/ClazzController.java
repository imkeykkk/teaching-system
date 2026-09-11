package com.imkeykkk.course.controller;

import com.imkeykkk.course.entity.Clazz;
import com.imkeykkk.course.service.ClazzService;
import com.imkeykkk.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public List<Clazz> list() {
        return clazzService.list();
    }

    @GetMapping("/{id}")
    public Clazz getById(@PathVariable Long id) {
        return clazzService.getById(id);
    }

    @PostMapping
    public String add(@RequestBody Clazz clazz) {
        clazzService.add(clazz);
        return "新增成功";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Clazz clazz) {
        clazz.setId(id);
        clazzService.update(clazz);
        return "修改成功";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        clazzService.delete(id);
        return "删除成功";
    }
    
    
}
