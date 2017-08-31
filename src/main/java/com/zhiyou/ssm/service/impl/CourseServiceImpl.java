package com.zhiyou.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.ssm.mapper.CourseMapper;
import com.zhiyou.ssm.model.Condition;
import com.zhiyou.ssm.model.Course;
import com.zhiyou.ssm.service.CourseService;
import com.zhiyou.ssm.util.Page;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseMapper cm;

	@Override
	public List<Course> selectAllCourseName() {
		return cm.selectAllCourseName();
	}

	@Override
	public String selectCourseNameByCourseId(Integer course_id) {
		return cm.selectCourseNameByCourseId(course_id);
	}

	@Override
	public Integer selectCourseCountByCondition(Condition cd) {
		Integer count = cm.selectCourseCountByCondition(cd);
		System.out.println(count);
		return count;
	}
	
	@Override
	public Page<Course> selectCourseByCondition(Integer currentpage) {
		Condition cd = new Condition();
		cd.setItem((currentpage-1)*5);
		
		List<Course> list = cm.selectCourseByCondition(cd);
		System.out.println(list);
		
		Page<Course> page = new Page<Course>();
		page.setTotal(selectCourseCountByCondition(cd));
		page.setSize(5);
		page.setPage(currentpage);
		page.setRows(list);
		return page;
	}

	@Override
	public void addCourse(Course course) {
		cm.addCourse(course);
	}

	@Override
	public Course selectCourseById(Integer id) {
		return cm.selectCourseById(id);
	}

	@Override
	public void deleteCourse(Integer id) {
		cm.deleteCourse(id);
	}

	@Override
	public void updateCourse(Course course) {
		cm.updateCourse(course);
	}

	@Override
	public List<Course> selectAllCourse() {
		return cm.selectAllCourse();
	}

}
