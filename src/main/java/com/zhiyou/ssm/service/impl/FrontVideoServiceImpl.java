package com.zhiyou.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.ssm.mapper.FrontVideoMapper;
import com.zhiyou.ssm.model.Video;

@Service("FrontVideoServiceImpl")
public class FrontVideoServiceImpl implements com.zhiyou.ssm.service.FrontVideoService {

	@Autowired
	FrontVideoMapper fvm;

	@Override
	public Video selectVideoByVideoId(Integer videoId) {
		return fvm.selectVideoByVideoId(videoId);
	}

	@Override
	public List<Video> selectVideoBySpeakerId(Integer speakerid) {
		return fvm.selectVideoBySpeakerId(speakerid);
	}

	@Override
	public void UpdateVideoPlayTimesByVideoId(Integer videoId) {
		Video video = fvm.selectVideoByVideoId(videoId);
		System.out.println("shezhi前"+video.getVideo_play_times());
		video.setVideo_play_times(video.getVideo_play_times()+1);
		System.out.println("shezhi后"+video.getVideo_play_times());
		fvm.UpdateVideoPlayTimesByVideoId(video);
	}
	
}
