package com.zhiyou.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.ssm.mapper.AdminMapper;
import com.zhiyou.ssm.model.Admin;
import com.zhiyou.ssm.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper am;
	
	@Override
	public Admin queryEmail(String email) {
		return am.queryEmail(email);
	}

	@Override
	public void addAdmin(Admin admin) {
		am.addAdmin(admin);
	}

	@Override
	public Admin selectAdminInfo(String email) {
		return am.selectAdminInfo(email);
	}

	@Override
	public String selectEmailActiveCode(Integer id) {
		return am.selectEmailActiveCode(id);
	}

	@Override
	public void changeEmailStatus(Admin admin) {
		am.changeEmailStatus(admin);
	}

	@Override
	public List<Admin> selectAdminLoginInfo(Admin admin) {
		return am.selectAdminLoginInfo(admin);
	}

	@Override
	public void updateCaptcha(Admin admin) {
		am.updateCaptcha(admin);
	}

	@Override
	public void updatePassword(Admin admin) {
		am.updatePassword(admin);
	}

}
