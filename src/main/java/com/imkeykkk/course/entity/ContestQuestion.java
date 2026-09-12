package com.imkeykkk.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("contest_question")
public class ContestQuestion {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long contestId;

    private Long questionId;
}