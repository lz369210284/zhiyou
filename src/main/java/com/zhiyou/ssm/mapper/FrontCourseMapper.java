package com.zhiyou.ssm.mapper;

import java.util.List;

import com.zhiyou.ssm.model.Course;
import com.zhiyou.ssm.model.Cvs;

public interface FrontCourseMapper {

	List<Cvs> selectAllInfoBySubjectId(int subjectId);

	List<Course> selectCourseBySubjectId(Integer subjectId);

}
