package com.imkeykkk.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("question")
public class Question {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;

    private Integer questionType;

    private Integer contestType;

    private Integer difficulty;

    private String content;

    private Long orgId;

    private Long creatorId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}