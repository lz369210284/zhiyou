package com.zhiyou.ssm.web.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomHandlerException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception exception) {

		System.out.println(request+"--"+response+"--"+obj+"---"+exception);
		ModelAndView md = new ModelAndView();
		md.addObject("obj", obj);
		md.addObject("error", exception);
		md.setViewName("forward:/error.jsp");
		return md;
	}

}
