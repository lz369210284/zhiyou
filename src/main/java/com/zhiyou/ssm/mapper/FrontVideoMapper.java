package com.zhiyou.ssm.mapper;

import java.util.List;

import com.zhiyou.ssm.model.Video;

public interface FrontVideoMapper {

	Video selectVideoByVideoId(Integer videoId);

	List<Video> selectVideoBySpeakerId(Integer speakerid);

	void UpdateVideoPlayTimesByVideoId(Video video);

}
