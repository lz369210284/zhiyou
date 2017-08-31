package com.zhiyou.ssm.mapper;

import java.util.List;

import com.zhiyou.ssm.model.Condition;
import com.zhiyou.ssm.model.Video;

public interface VideoMapper {

	List<Video> selectAllVideo();

	List<Video> selectVideoByCondition(Condition cd);
	
	Integer selectVideoCountByCondition(Condition cd);

	void addVideo(Video video);

	Video selectVideoById(Integer id);

	void updateVideo(Video video);

	void deleteVideo(Integer id);

	void deleteManyVideo(Condition cd);

	List<Video> selectAvgVideo();
}
