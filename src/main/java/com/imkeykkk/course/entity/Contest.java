package com.imkeykkk.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("contest")
public class Contest {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;

    private Integer contestType;

    private Integer status;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Long orgId;

    private Long creatorId;

    private Long updaterId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}