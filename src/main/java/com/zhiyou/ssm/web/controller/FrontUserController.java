package com.zhiyou.ssm.web.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.ssm.model.Admin;
import com.zhiyou.ssm.service.FrontUserService;

@Controller("frontUserController")
@RequestMapping("/front/user")
public class FrontUserController {

	@Autowired
	FrontUserService fus;
	
	@RequestMapping("/logout.action")
	public String logout(HttpSession session){
		session.removeAttribute("_front_user");
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/login.action")
	public String login(){
		
		return "forward:/index.jsp";		
	}
	
	@RequestMapping("/index.action")
	public String index(HttpSession session,Model md){
		Admin admin = (Admin)session.getAttribute("_front_user");
		System.out.println(admin);
		md.addAttribute("user", admin);
		return "forward:/WEB-INF/front/user/index.jsp";
	}
	
	@RequestMapping(value="/profile.action",method=RequestMethod.GET)
	public String profile(HttpSession session,Model md){
		Admin admin = (Admin)session.getAttribute("_front_user");
		System.out.println(admin);
		md.addAttribute("user", admin);
		return "forward:/WEB-INF/front/user/profile.jsp";
	}
	
	@RequestMapping(value="/profile.action",method=RequestMethod.POST)
	public String changeInfo(){
		return "forward:/front/user/index.action";
	}
	
	@RequestMapping(value="/avatar.action",method=RequestMethod.GET)
	public String avator(HttpSession session,Model md){
		Admin admin = (Admin)session.getAttribute("_front_user");
		md.addAttribute("user", admin);
		return "forward:/WEB-INF/front/user/avatar.jsp";
	}
	
	@RequestMapping(value="/avatar.action",method=RequestMethod.POST)
	public String avator(HttpSession session,MultipartFile image_file,Model md) throws Exception{
		System.out.println(image_file);
		String str = UUID.randomUUID().toString().replaceAll("-", "");
		String filename = str+"."+image_file.getOriginalFilename().split("\\.")[1];
		System.out.println(filename);
		String path = "D:\\upload\\";
		image_file.transferTo(new File(path+filename));
		Admin admin = (Admin)session.getAttribute("_front_user");
		admin.setHeadUrl(filename);
		fus.updateAdminHeadUrl(admin);
		return "forward:/front/user/index.action";
	}
	
	@RequestMapping(value="/password.action",method=RequestMethod.GET)
	public String password(HttpSession session,Model md){
		Admin admin = (Admin)session.getAttribute("_front_user");
		System.out.println(admin);
		md.addAttribute("user", admin);
		return "forward:/WEB-INF/front/user/password.jsp";
	}
	
	@RequestMapping(value="/password.action",method=RequestMethod.POST)
	public String password(HttpSession session,String newPassword){
		Admin admin = (Admin)session.getAttribute("_front_user");
		admin.setPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
		fus.updatePassword(admin);
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value="/queryPassword.action")
	@ResponseBody
	public String queryPassword(String oldPassword,HttpSession session){
		Admin admin = (Admin)session.getAttribute("_front_user");
		String pwd = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
		if(admin.getPassword().equals(pwd)){
			return "success";
		}
		return "fail";
	}
}
