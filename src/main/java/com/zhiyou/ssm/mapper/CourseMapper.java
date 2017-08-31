package com.zhiyou.ssm.mapper;

import java.util.List;

import com.zhiyou.ssm.model.Condition;
import com.zhiyou.ssm.model.Course;

public interface CourseMapper {

	List<Course> selectAllCourseName();

	String selectCourseNameByCourseId(Integer course_id);

	Integer selectCourseCountByCondition(Condition cd);

	List<Course> selectCourseByCondition(Condition cd);

	void addCourse(Course course);

	Course selectCourseById(Integer id);

	void deleteCourse(Integer id);

	void updateCourse(Course course);

	List<Course> selectAllCourse();

}
