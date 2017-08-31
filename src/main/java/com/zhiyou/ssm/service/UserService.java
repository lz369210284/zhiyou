package com.zhiyou.ssm.service;

import com.zhiyou.ssm.model.User;

public interface UserService {

	User login(String login_name,String login_pwd);
}
