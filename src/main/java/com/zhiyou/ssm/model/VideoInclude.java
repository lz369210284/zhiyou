package com.zhiyou.ssm.model;

import java.util.List;

public class VideoInclude {
	private Video video;
	private List<Video> videolist;
	private String speaker_name;
	private String course_name;

	
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public List<Video> getVideolist() {
		return videolist;
	}
	public void setVideolist(List<Video> videolist) {
		this.videolist = videolist;
	}
	public String getSpeaker_name() {
		return speaker_name;
	}
	public void setSpeaker_name(String speaker_name) {
		this.speaker_name = speaker_name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	@Override
	public String toString() {
		return "VideoInclude [video=" + video + ", videolist=" + videolist + ", speaker_name=" + speaker_name
				+ ", course_name=" + course_name + "]";
	}

}
