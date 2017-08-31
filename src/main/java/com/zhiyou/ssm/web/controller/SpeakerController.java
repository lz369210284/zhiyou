package com.zhiyou.ssm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou.ssm.model.Condition;
import com.zhiyou.ssm.model.Speaker;
import com.zhiyou.ssm.service.SpeakerService;
import com.zhiyou.ssm.util.Page;

@Controller("speakerController")
@RequestMapping("/user/speaker")
public class SpeakerController {

	@Autowired
	SpeakerService ss;
	
	@RequestMapping(value="addTeacherjsp.action")
	public String addSpeakerJsp(Model md){
		return "/speaker/addspeaker";
	}
	
	@RequestMapping(value="addspeaker.action")
	public String addSpeaker(Speaker speaker,Model md){
		System.out.println(speaker);
		ss.addSpeaker(speaker);
		return "redirect:/speaker/selectSpeakerByCondition.action";
	}

	@RequestMapping(value="updatespeaker.action")
	public String updateVideoInfo(Speaker speaker,Model md){
		System.out.println(speaker);
		ss.updateSpeaker(speaker);
		return "redirect:/speaker/selectSpeakerByCondition.action";
	}
	
	@RequestMapping(value="updatespeakerjsp.action")
	public String updateVideo(Integer id,Model md){
		System.out.println(id);
		Speaker speaker = ss.selectSpeakerById(id);
		System.out.println(speaker);
		md.addAttribute("speaker", speaker);
		return "/speaker/updatespeaker";
	}
	
	@RequestMapping(value="deletespeaker.action")
	public String deleteVideo(Integer id,Model md){
		System.out.println(id);
		ss.deleteSpeaker(id);
		return "redirect:/speaker/selectSpeakerByCondition.action";
	}
	
	@RequestMapping(value="selectSpeakerByCondition.action")
	public String selectSpeakerByCondition(
			@RequestParam(required=false,defaultValue="")String speaker_name,
			@RequestParam(required=false,defaultValue="")String speaker_job,
			@RequestParam(required=false,defaultValue="1")Integer page,
			Condition cd,Model md){	

		md.addAttribute("speaker_name", speaker_name);
		md.addAttribute("speaker_job", speaker_job);
	
		Page<Speaker> pageinfo = ss.selectSpeakerByCondition(speaker_name,speaker_job,page);
		md.addAttribute("page", pageinfo);
		
		return "/speaker/speakerlist";
	}
}
