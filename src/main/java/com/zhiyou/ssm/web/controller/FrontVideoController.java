package com.zhiyou.ssm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.ssm.model.Subject;
import com.zhiyou.ssm.model.Video;
import com.zhiyou.ssm.service.FrontSubjectService;
import com.zhiyou.ssm.service.FrontVideoService;

@Controller("frontVideoController")
@RequestMapping("/front/video")
public class FrontVideoController {
	
	@Autowired
	FrontVideoService fvs;
	@Autowired
	FrontSubjectService fss;
	
	@RequestMapping("/index.action")
	public String index(Integer videoId,Integer subjectId,Model md){
		Subject subject = fss.selectSubjectBySubjectId(subjectId);
		md.addAttribute("subject", subject);
		md.addAttribute("subjectId", subjectId);
		md.addAttribute("videoId", videoId);
		return "forward:/WEB-INF/front/video/index.jsp";
	}
	
	@RequestMapping("/videoData.action")
	public String videoData(Integer videoId,Integer subjectId,Model md){
		System.out.println(videoId);
		Video video = fvs.selectVideoByVideoId(videoId);
		System.out.println(video);
		System.out.println(video.getCourse());
		System.out.println(video.getSpeaker());
		List<Video> videolist = fvs.selectVideoBySpeakerId(video.getSpeaker().getId());
		System.out.println(videolist);
		md.addAttribute("video", video);
		md.addAttribute("course", video.getCourse());
		md.addAttribute("speaker", video.getSpeaker());
		md.addAttribute("videolist", videolist);
		md.addAttribute("subjectId", subjectId);
		return "forward:/WEB-INF/front/video/content.jsp";
	}
	
	@RequestMapping("/state.action")
	public void state(Integer videoId){
		System.out.println(videoId);
		System.out.println("播放次数");
		fvs.UpdateVideoPlayTimesByVideoId(videoId);
	}
}
