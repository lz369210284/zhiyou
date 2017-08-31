package com.zhiyou.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.ssm.mapper.ChartMapper;
import com.zhiyou.ssm.service.ChartService;

@Service("chartService")
public class ChartServiceImpl implements ChartService {

	@Autowired
	ChartMapper cm;
	
	
}
