package com.zhiyou.ssm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.ssm.model.User;
import com.zhiyou.ssm.service.CourseService;
import com.zhiyou.ssm.service.SpeakerService;
import com.zhiyou.ssm.service.UserService;
import com.zhiyou.ssm.service.VideoService;

@Controller("userController")
@RequestMapping("/user/user")
public class UserController {

	@Autowired
	UserService us;
	@Autowired
	VideoService vs;
	@Autowired
	SpeakerService ss;
	@Autowired
	CourseService cs;
	
	@RequestMapping("/login.action")
	public String login(String login_name,String login_pwd,HttpSession session,Model md){
		byte[] bytes = login_pwd.getBytes();
		String pwd = DigestUtils.md5DigestAsHex(bytes);
		System.out.println(login_name+"--"+pwd);
		User user = us.login(login_name, pwd);
		if(user!=null){
			session.setAttribute("user", user);
			/*return "forward:/video/selectVideoByCondition.action";*/
			/*return "redirect:/video/selectVideoByCondition.action";*/
			return "forward:/WEB-INF/view/head.jsp";
		}
		return "forward:login.jsp";
	}
	
	
	@RequestMapping("/loginout.action")
	public String loginout(HttpSession session,Model md){
		session.invalidate();
		return "forward:/front/admin/back/login.action";
	}
}
