package com.imkeykkk.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("org")
public class Org {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String address;

    private LocalDateTime createdAt;
}