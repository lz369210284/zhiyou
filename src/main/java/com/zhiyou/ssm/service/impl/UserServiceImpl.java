package com.zhiyou.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.ssm.mapper.UserMapper;
import com.zhiyou.ssm.model.User;
import com.zhiyou.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper um;
	@Override
	public User login(String login_name,String login_pwd) {
		User u = new User();
		u.setLogin_name(login_name);
		u.setLogin_pwd(login_pwd);
		return um.login(u);
	}

}
