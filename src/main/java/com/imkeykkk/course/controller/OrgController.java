package com.imkeykkk.course.controller;

import com.imkeykkk.course.mapper.OrgMapper;
import com.imkeykkk.course.entity.Org;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrgController {

    @Autowired
    private OrgMapper orgMapper;

    @GetMapping("/orgs")
    public List<Org> list() {
        return orgMapper.selectList(null);
    }
}