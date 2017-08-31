package com.zhiyou.ssm.service;

import java.util.List;

import com.zhiyou.ssm.model.Condition;
import com.zhiyou.ssm.model.Speaker;
import com.zhiyou.ssm.util.Page;

public interface SpeakerService {

	List<Speaker> selectAllSpeakerName();

	String selectSpeakerNameBySpeakerId(Integer speaker_id);

	Page<Speaker> selectSpeakerByCondition(String speaker_name, String speaker_job, Integer page);

	Integer selectSpeakerCountByCondition(Condition cd);

	void addSpeaker(Speaker speaker);

	Speaker selectSpeakerById(Integer id);

	void updateSpeaker(Speaker speaker);

	void deleteSpeaker(Integer id);

}
