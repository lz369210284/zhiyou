package com.zhiyou.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.ssm.mapper.SubjectMapper;
import com.zhiyou.ssm.model.Subject;
import com.zhiyou.ssm.service.SubjectService;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectMapper sjm;
	@Override
	public List<Subject> selectAllSubject() {
		return sjm.selectAllSubject();
	}

}
