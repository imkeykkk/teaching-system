package com.imkeykkk.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("chapter_question")
public class ChapterQuestion {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long chapterId;

    private Long questionId;
}