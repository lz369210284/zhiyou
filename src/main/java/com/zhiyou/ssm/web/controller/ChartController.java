package com.zhiyou.ssm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhiyou.ssm.model.Video;
import com.zhiyou.ssm.service.ChartService;
import com.zhiyou.ssm.service.VideoService;

@Controller("chartController")
@RequestMapping("/user/chart")
public class ChartController {
	
	@Autowired
	ChartService chs;
	@Autowired
	VideoService vs;

	@RequestMapping("/chartInfo.action")
	public String chartInfo(){
		return "chart/chart";
	}
	
	@RequestMapping("/querydata.action")
	@ResponseBody
	public String queryData() throws Exception{
		List<Video> videolist = vs.selectAvgVideo();
		ObjectMapper mapper = new ObjectMapper();    
		String json = mapper.writeValueAsString(videolist); 		
		return json;

	}
}
