package com.imkeykkk.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("users")
public class User {

    @TableId(type = IdType.AUTO)//用于标识实体主键的注解，‌表示主键值由数据库自增生成
    private Long id;

    private String username;

    private String password;

    private String realName;

    private Integer role;

    private Long orgId;

    private LocalDateTime createdAt;
}