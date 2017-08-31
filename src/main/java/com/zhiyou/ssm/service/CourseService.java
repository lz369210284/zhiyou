package com.zhiyou.ssm.service;

import java.util.List;

import com.zhiyou.ssm.model.Condition;
import com.zhiyou.ssm.model.Course;
import com.zhiyou.ssm.util.Page;

public interface CourseService {

	List<Course> selectAllCourseName();

	String selectCourseNameByCourseId(Integer course_id);

	Page<Course> selectCourseByCondition(Integer page);

	Integer selectCourseCountByCondition(Condition cd);

	void addCourse(Course course);

	Course selectCourseById(Integer id);

	void deleteCourse(Integer id);

	void updateCourse(Course course);

	List<Course> selectAllCourse();

}
