package com.zhiyou.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.ssm.mapper.SpeakerMapper;
import com.zhiyou.ssm.model.Condition;
import com.zhiyou.ssm.model.Speaker;
import com.zhiyou.ssm.service.SpeakerService;
import com.zhiyou.ssm.util.Page;

@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {

	@Autowired
	SpeakerMapper sm;
	
	@Override
	public List<Speaker> selectAllSpeakerName() {
		return sm.selectAllSpeakerName();
	}
	
	@Override
	public String selectSpeakerNameBySpeakerId(Integer speaker_id) {
		return sm.selectSpeakerNameBySpeakerId(speaker_id);
	}
	
	@Override
	public Integer selectSpeakerCountByCondition(Condition cd) {
		Integer count = sm.selectSpeakerCountByCondition(cd);
		System.out.println(count);
		return count;
	}
	
	@Override
	public Page<Speaker> selectSpeakerByCondition(String speaker_name, String speaker_job, Integer currentpage) {
		Condition cd = new Condition();
		cd.setItem((currentpage-1)*5);
		cd.setSpeaker_job(speaker_job);
		cd.setSpeaker_name(speaker_name);
		
		List<Speaker> list = sm.selectSpeakerByCondition(cd);
		System.out.println(list);
		
		Page<Speaker> page = new Page<Speaker>();
		page.setTotal(selectSpeakerCountByCondition(cd));
		page.setSize(5);
		page.setPage(currentpage);
		page.setRows(list);
		return page;
	}

	@Override
	public void addSpeaker(Speaker speaker) {
		sm.addSpeaker(speaker);
	}

	@Override
	public Speaker selectSpeakerById(Integer id) {
		return sm.selectSpeakerById(id);
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		sm.updateSpeaker(speaker);
	}

	@Override
	public void deleteSpeaker(Integer id) {
		sm.deleteSpeaker(id);
	}

}
