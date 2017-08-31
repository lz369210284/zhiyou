package com.zhiyou.ssm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.ssm.model.Admin;
import com.zhiyou.ssm.service.AdminService;
import com.zhiyou.ssm.util.MailUtil;

@Controller("adminController")
@RequestMapping("/front/admin")
public class AdminController {

	@Autowired
	AdminService as;
	
	@RequestMapping("/back/login.action")
	public String backManage(){
		return "index";		
	}
	
	@RequestMapping("/login.action")
	@ResponseBody
	public String login(Admin admin1,HttpSession session){
		String pwd = DigestUtils.md5DigestAsHex(admin1.getPassword().getBytes());
		admin1.setPassword(pwd);
		List<Admin> list = as.selectAdminLoginInfo(admin1);
		Admin admin = list.get(0);
		if(admin.getStatus()==1){
			session.setAttribute("_front_user", admin);
			return "success";
		}
		return "fail";		
	}
	
	@RequestMapping("/regist.action")
	@ResponseBody
	public String registAdmin(Admin admin) throws Exception{
		System.out.println(admin);
		Admin ad = as.queryEmail(admin.getEmail());
		if(ad!=null){
			return "用户已存在";
		}else{
			String pwd = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());
			admin.setPassword(pwd);
			String activeCode = admin.getEmail()+admin.getPassword()+System.currentTimeMillis();
			System.out.println(activeCode);
			admin.setActive_code(activeCode);
			as.addAdmin(admin);
			/*
			 * 0. MD5(邮箱+密码+当前时间)就是激活码  24小时有效
			 * 1.id(uuid)  邮箱地址   状态(0未激活,1表示激活)   激活码     失效时间
			 * 2.http://localhost:8080/Test/Mail/active.action?id=id&activeCode=激活码 
			 */
			Admin admin1 = as.selectAdminInfo(admin.getEmail());
			System.out.println(admin1);
			String activeAddress = "192.168.6.225:8080/ssm-video/front/admin/jihuo.action?id="+admin1.getId()+"&active_code="+admin1.getActive_code();
			System.out.println("<a href=\""+activeAddress+"\">"+activeAddress+"</a>");
			MailUtil.send(admin.getEmail(), "激活账号", "<a href=\"http://"+activeAddress+"\">"+activeAddress+"</a>");
			return "success";
		}				
	}
	
	@RequestMapping("/jihuo.action")
	public String activeEmail(Admin admin){
		System.out.println(admin.getId()+"---"+admin.getActive_code());
		String activeCode1 = as.selectEmailActiveCode(admin.getId());
		System.out.println(activeCode1);
		if(admin.getActive_code().equals(activeCode1)){
			as.changeEmailStatus(admin);
		}
		return "forward:/index.jsp";		
	}
	
	@RequestMapping(value="/forgetpwd.action",method=RequestMethod.GET)
	public String forgetpwd(String email){
		return "forward:/WEB-INF/front/user/forget_pwd.jsp";
	}
	
	@RequestMapping(value="/forgetpwd.action",method=RequestMethod.POST)
	public String forgetPwd(String email,String captcha,Model md){
		md.addAttribute("email", email);
		md.addAttribute("captcha", captcha);
		return "forward:/WEB-INF/front/user/reset_pwd.jsp";
	}
	
	@RequestMapping("/sendemail.action")
	public String sendMail(String email) throws Exception{
		System.out.println(email);
		Admin admin = as.selectAdminInfo(email);
		int captcha = (int)(Math.random()*(9999-1000+1))+1000;//产生1000-9999的随机数
		admin.setCaptcha(Integer.toString(captcha));
		as.updateCaptcha(admin);
		MailUtil.send(admin.getEmail(), "验证码", ""+captcha);
		return "success";
	}
	
	@RequestMapping("/changePwd.action")
	@ResponseBody
	public String changePwd(String email,String captcha) throws Exception{
		System.out.println(captcha);
		Admin admin = as.selectAdminInfo(email);
		System.out.println(admin.getCaptcha());
		if(admin.getCaptcha().equals(captcha)){
			System.out.println(111);
			return "success";
		}
		return "fail";
	}
	
	@RequestMapping("/resetpwd.action")
	public String resetPwd(String email,String password) throws Exception{
		Admin admin = as.selectAdminInfo(email);
		admin.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
		as.updatePassword(admin);
		return "redirect:/index.jsp";
	}
}
