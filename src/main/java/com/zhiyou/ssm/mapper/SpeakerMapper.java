package com.zhiyou.ssm.mapper;

import java.util.List;

import com.zhiyou.ssm.model.Condition;
import com.zhiyou.ssm.model.Speaker;

public interface SpeakerMapper {

	List<Speaker> selectAllSpeakerName();

	String selectSpeakerNameBySpeakerId(Integer speaker_id);

	List<Speaker> selectSpeakerByCondition(Condition cd);

	Integer selectSpeakerCountByCondition(Condition cd);

	void addSpeaker(Speaker speaker);

	void updateSpeaker(Speaker speaker);

	Speaker selectSpeakerById(Integer id);

	void deleteSpeaker(Integer id);

}
