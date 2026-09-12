package com.imkeykkk.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("question_list")
public class QuestionList {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;

    private String category;

    private Long isPublic;

    private Long orgId;

    private Long creatorId;

    private String createdAt;
}
