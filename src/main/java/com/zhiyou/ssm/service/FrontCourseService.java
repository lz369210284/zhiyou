package com.zhiyou.ssm.service;

import java.util.List;

import com.zhiyou.ssm.model.Course;
import com.zhiyou.ssm.model.Cvs;

public interface FrontCourseService {

	List<Cvs> selectAllInfoBySubjectId(int subjectId);

	List<Course> selectCourseBySubjectId(Integer subjectId);

}
