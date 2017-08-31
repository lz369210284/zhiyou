package com.zhiyou.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.ssm.mapper.VideoMapper;
import com.zhiyou.ssm.model.Condition;
import com.zhiyou.ssm.model.Video;
import com.zhiyou.ssm.service.VideoService;
import com.zhiyou.ssm.util.Page;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	VideoMapper vm;

	@Override
	public List<Video> selectAllVideo() {
		return vm.selectAllVideo();
	}

	@Override
	public Page<Video> selectVideoByCondition(String video_title,String speaker_name,String course_name,Integer currentpage) {
		
		Condition cd = new Condition();
		cd.setItem((currentpage-1)*5);
		cd.setVideo_title(video_title);
		cd.setCourse_name(course_name);
		cd.setSpeaker_name(speaker_name);
		
		List<Video> list = vm.selectVideoByCondition(cd);
		System.out.println(list);
		
		Page<Video> page = new Page<Video>();
		page.setTotal(selectVideoCountByCondition(cd));
		page.setSize(5);
		page.setPage(currentpage);
		page.setRows(list);
		return page;
	}

	@Override
	public Integer selectVideoCountByCondition(Condition cd) {
		Integer count = vm.selectVideoCountByCondition(cd);
		System.out.println(count);
		return count;
	}

	@Override
	public void addVideo(Video video) {
		vm.addVideo(video);
	}

	@Override
	public Video selectVideoById(Integer id) {
		return vm.selectVideoById(id);
	}

	@Override
	public void updateVideo(Video video) {
		vm.updateVideo(video);
	}

	@Override
	public void deleteVideo(Integer id) {
		vm.deleteVideo(id);
	}

	@Override
	public void deleteManyVideo(Condition cd) {
		vm.deleteManyVideo(cd);
	}

	@Override
	public List<Video> selectAvgVideo() {
		return vm.selectAvgVideo();
	}


}
