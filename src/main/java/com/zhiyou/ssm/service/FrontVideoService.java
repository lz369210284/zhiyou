package com.zhiyou.ssm.service;

import java.util.List;

import com.zhiyou.ssm.model.Video;

public interface FrontVideoService {

	Video selectVideoByVideoId(Integer videoId);

	List<Video> selectVideoBySpeakerId(Integer id);

	void UpdateVideoPlayTimesByVideoId(Integer videoId);

}
