package com.zhiyou.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.ssm.mapper.FrontUserMapper;
import com.zhiyou.ssm.model.Admin;
import com.zhiyou.ssm.service.FrontUserService;

@Service("frontUserService")
public class FrontUserServiceImpl implements FrontUserService {

	@Autowired
	FrontUserMapper fum;
	
	@Override
	public void updateAdminInfo(Admin admin) {
		fum.updateAdminInfo(admin);
	}

	@Override
	public void updateAdminHeadUrl(Admin admin) {
		fum.updateAdminHeadUrl(admin);
	}

	@Override
	public void updatePassword(Admin admin) {
		fum.updatePassword(admin);
	}

}
