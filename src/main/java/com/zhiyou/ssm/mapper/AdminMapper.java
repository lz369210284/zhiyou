package com.zhiyou.ssm.mapper;

import java.util.List;

import com.zhiyou.ssm.model.Admin;

public interface AdminMapper {

	Admin queryEmail(String email);

	void addAdmin(Admin admin);

	Admin selectAdminInfo(String email);

	String selectEmailActiveCode(Integer id);

	void changeEmailStatus(Admin admin);

	List<Admin> selectAdminLoginInfo(Admin admin);

	void updateCaptcha(Admin admin);

	void updatePassword(Admin admin);

}
