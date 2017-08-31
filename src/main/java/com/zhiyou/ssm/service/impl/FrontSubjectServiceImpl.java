package com.zhiyou.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.ssm.mapper.FrontSubjectMapper;
import com.zhiyou.ssm.model.Subject;
import com.zhiyou.ssm.service.FrontSubjectService;

@Service("frontSubjectService")
public class FrontSubjectServiceImpl implements FrontSubjectService {

	
	@Autowired
	FrontSubjectMapper fsm;

	@Override
	public Subject selectSubjectBySubjectId(Integer subjectId) {
		return fsm.selectSubjectBySubjectId(subjectId);
	}
	
	
}
