package com.zhiyou.ssm.service;

import com.zhiyou.ssm.model.Admin;

public interface FrontUserService {

	void updateAdminInfo(Admin admin);

	void updateAdminHeadUrl(Admin admin);

	void updatePassword(Admin admin);

}
