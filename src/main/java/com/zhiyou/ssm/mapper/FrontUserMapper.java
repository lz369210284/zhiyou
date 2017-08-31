package com.zhiyou.ssm.mapper;

import com.zhiyou.ssm.model.Admin;

public interface FrontUserMapper {

	void updateAdminInfo(Admin admin);

	void updateAdminHeadUrl(Admin admin);

	void updatePassword(Admin admin);

}
