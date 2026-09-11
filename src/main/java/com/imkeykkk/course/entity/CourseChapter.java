package com.imkeykkk.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("course_chapter")
public class CourseChapter {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long courseId;

    private String name;

    private Integer sortOrder;

    private String remark;

    private Long creatorId;

    private LocalDateTime updatedAt;
}