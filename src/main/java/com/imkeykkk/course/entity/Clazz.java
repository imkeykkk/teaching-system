package com.imkeykkk.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("class")
public class Clazz {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String grade;

    private Integer studentCount;

    private Integer status;

    private Long orgId;

    private Long creatorId;

    private LocalDateTime createdAt;
}