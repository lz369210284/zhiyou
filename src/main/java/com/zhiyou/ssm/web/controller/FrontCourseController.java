package com.zhiyou.ssm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.ssm.model.Course;
import com.zhiyou.ssm.model.Subject;
import com.zhiyou.ssm.service.FrontCourseService;
import com.zhiyou.ssm.service.FrontSubjectService;

@Controller("frontCourseController")
@RequestMapping("/front/course")
public class FrontCourseController {

	@Autowired
	FrontCourseService fcs;
	@Autowired
	FrontSubjectService fss;
	
	@RequestMapping("/index.action")
	public String index(Integer subjectId,Model md){
		Subject subject = fss.selectSubjectBySubjectId(subjectId);
		System.out.println(subject);
		md.addAttribute("subject", subject);
		
		List<Course> courselist = fcs.selectCourseBySubjectId(subjectId);
		System.out.println(courselist);
		md.addAttribute("courselist", courselist);
		
		md.addAttribute("subjectId", subject.getId());
		return "forward:/WEB-INF/front/course/index.jsp";
	}
}
