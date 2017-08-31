package com.zhiyou.ssm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou.ssm.model.Condition;
import com.zhiyou.ssm.model.Course;
import com.zhiyou.ssm.model.Subject;
import com.zhiyou.ssm.service.CourseService;
import com.zhiyou.ssm.service.SubjectService;
import com.zhiyou.ssm.util.Page;

@Controller("courseController")
@RequestMapping("/user/course")
public class CourseController {

	@Autowired
	CourseService cs;
	@Autowired
	SubjectService sjs;
	
	@RequestMapping(value="addCoursejsp.action")
	public String addCourseJsp(Model md){
		List<Subject> subjectlist = sjs.selectAllSubject();
		System.out.println(subjectlist);
		md.addAttribute("subjectlist", subjectlist);
		return "/course/addcourse";
	}
	
	@RequestMapping(value="addcourse.action")
	public String addCourse(Course course,Model md){
		System.out.println(course);
		cs.addCourse(course);
		return "redirect:/course/selectCourseByCondition.action";
	}
	
	@RequestMapping(value="updatecoursejsp.action")
	public String updateCourse(Integer id,Model md){
		System.out.println(id);
		Course course = cs.selectCourseById(id);
		List<Subject> subjectlist = sjs.selectAllSubject();
		System.out.println(course);
		md.addAttribute("course", course);
		md.addAttribute("subjectlist", subjectlist);
		return "/course/updatecourse";
	}
	
	@RequestMapping(value="updatecourse.action")
	public String updateCourseInfo(Course course,Model md){
		System.out.println(course);
		cs.updateCourse(course);
		return "redirect:/course/selectCourseByCondition.action";
	}
	
	@RequestMapping(value="deletecourse.action")
	public String deleteCourse(Integer id,Model md){
		System.out.println(id);
		cs.deleteCourse(id);
		return "redirect:/course/selectCourseByCondition.action";
	}
	
	@RequestMapping(value="selectCourseByCondition.action")
	public String selectCourseByCondition(
			@RequestParam(required=false,defaultValue="1")Integer page,
			Condition cd,Model md){	
	
		Page<Course> pageinfo = cs.selectCourseByCondition(page);
		md.addAttribute("page", pageinfo);
		
		return "/course/courselist";
	}
}
