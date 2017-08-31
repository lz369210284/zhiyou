package com.zhiyou.ssm.service;

import java.util.List;

import com.zhiyou.ssm.model.Condition;
import com.zhiyou.ssm.model.Video;
import com.zhiyou.ssm.util.Page;

public interface VideoService {

	List<Video> selectAllVideo();

	Page<Video> selectVideoByCondition(String video_title,String speaker_name,String course_name,Integer currentpage);
	
	Integer selectVideoCountByCondition(Condition cd);

	void addVideo(Video video);

	Video selectVideoById(Integer id);

	void updateVideo(Video video);

	void deleteVideo(Integer id);

	void deleteManyVideo(Condition cd);

	List<Video> selectAvgVideo();

}
