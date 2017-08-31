package com.zhiyou.ssm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.ssm.model.Condition;
import com.zhiyou.ssm.model.Course;
import com.zhiyou.ssm.model.Speaker;
import com.zhiyou.ssm.model.Video;
import com.zhiyou.ssm.service.CourseService;
import com.zhiyou.ssm.service.SpeakerService;
import com.zhiyou.ssm.service.VideoService;
import com.zhiyou.ssm.util.Page;

@Controller("videoController")
@RequestMapping("/user/video")
public class VideoController {
	
	@Autowired
	VideoService vs;
	@Autowired
	SpeakerService ss;
	@Autowired
	CourseService cs;
	
	@RequestMapping(value="addvideojsp.action")
	public String addVideoJsp(Model md){
		List<Speaker> speakernamelist = ss.selectAllSpeakerName();
		List<Course> coursenamelist = cs.selectAllCourseName();
		md.addAttribute("speakernamelist", speakernamelist);
		md.addAttribute("coursenamelist", coursenamelist);
		return "/video/addvideo";
	}
	
	@RequestMapping(value="addvideo.action")
	public String addVideo(Video video,Model md){
		System.out.println(video);
		vs.addVideo(video);
		return "redirect:/video/selectVideoByCondition.action";
	}
	
	@RequestMapping(value="updatevideojsp.action")
	public String updateVideo(Integer id,Model md){
		System.out.println(id);
		Video video = vs.selectVideoById(id);
		System.out.println(video);
		video.setSpeaker_name(ss.selectSpeakerNameBySpeakerId(video.getSpeaker_id()));
		video.setCourse_name(cs.selectCourseNameByCourseId(video.getCourse_id()));
		md.addAttribute("video", video);
		List<Speaker> speakernamelist = ss.selectAllSpeakerName();
		List<Course> coursenamelist = cs.selectAllCourseName();
		md.addAttribute("speakernamelist", speakernamelist);
		md.addAttribute("coursenamelist", coursenamelist);
		return "/video/updatevideo";
	}
	
	@RequestMapping(value="updatevideo.action")
	public String updateVideoInfo(Video video,Model md){
		System.out.println(video);
		vs.updateVideo(video);
		return "redirect:/video/selectVideoByCondition.action";
	}
	
	@RequestMapping(value="deletevideo.action")
	@ResponseBody
	public String deleteVideo(Integer id,Model md){
		System.out.println(id);
		vs.deleteVideo(id);
		return "success";
	}
	
	@RequestMapping(value="deleteManyVideo.action")
	public String deleteManyVideo(String manyid,Model md){
		System.out.println(manyid);
		Condition cd = new Condition();
		cd.setIds(manyid);
		vs.deleteManyVideo(cd);
		return "redirect:/video/selectVideoByCondition.action";
	}
	
	@RequestMapping(value="deleteMuchVideo.action")
	public String deleteMuchVideo(Integer[] checkbox,Model md){
		System.out.println(checkbox);
		for (Integer id : checkbox) {
			vs.deleteVideo(id);
		}
		return "redirect:/video/selectVideoByCondition.action";
	}
	
	@RequestMapping(value="selectVideoByCondition.action")
	public String selectVideoByCondition(@RequestParam(required=false,defaultValue="")String video_title,
			@RequestParam(required=false,defaultValue="")String speaker_name,
			@RequestParam(required=false,defaultValue="")String course_name,
			@RequestParam(required=false,defaultValue="1")Integer page,
			Condition cd,Model md){	
		
		System.out.println(video_title+"---"+speaker_name+"---"+course_name);
		md.addAttribute("video_title", video_title);
		md.addAttribute("speaker_name", speaker_name);
		md.addAttribute("course_name", course_name);
	
		Page<Video> pageinfo = vs.selectVideoByCondition(video_title,speaker_name,course_name,page);
		List<Speaker> speakernamelist = ss.selectAllSpeakerName();
		List<Course> coursenamelist = cs.selectAllCourseName();
		md.addAttribute("page", pageinfo);
		md.addAttribute("speakernamelist", speakernamelist);
		md.addAttribute("coursenamelist", coursenamelist);
		
		return "/video/videolist";
	}

}
