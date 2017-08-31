package com.zhiyou.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.ssm.mapper.FrontCourseMapper;
import com.zhiyou.ssm.model.Course;
import com.zhiyou.ssm.model.Cvs;
import com.zhiyou.ssm.service.FrontCourseService;

@Service("frontCourseService")
public class FrontCourseServiceImpl implements FrontCourseService {

	@Autowired
	FrontCourseMapper fcm;

	@Override
	public List<Cvs> selectAllInfoBySubjectId(int subjectId) {
		return fcm.selectAllInfoBySubjectId(subjectId);
	}

	@Override
	public List<Course> selectCourseBySubjectId(Integer subjectId) {
		return fcm.selectCourseBySubjectId(subjectId);
	}

}
