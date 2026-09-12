package com.imkeykkk.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("question_list_item")
public class QuestionListItem {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long questionListId;

    private Long questionId;
}