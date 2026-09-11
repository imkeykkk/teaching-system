package com.imkeykkk.course.service;

import com.imkeykkk.course.entity.CourseChapter;

import java.util.List;

public interface CourseChapterService {

    List<CourseChapter> getChaptersByCourseId(Long courseId);

    CourseChapter getChapterById(Long id);

    void addChapter(CourseChapter chapter);

    void updateChapter(CourseChapter chapter);

    void deleteChapter(Long id);
}