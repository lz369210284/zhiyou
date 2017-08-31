package com.zhiyou.ssm.model;

public class Condition {

	private String video_title;
	private String speaker_name;
	private String course_name;
	private String speaker_job;
	private Integer page;
	private Integer item;
	private String ids;
	
	public Integer getItem() {
		return item;
	}



	public String getSpeaker_job() {
		return speaker_job;
	}



	public void setSpeaker_job(String speaker_job) {
		this.speaker_job = speaker_job;
	}



	public String getIds() {
		return ids;
	}



	public void setIds(String ids) {
		this.ids = ids;
	}



	public void setItem(Integer item) {
		this.item = item;
	}



	public Integer getPage() {
		return page;
	}



	public void setPage(Integer page) {
		this.page = page;
	}



	public String getVideo_title() {
		return video_title;
	}



	public void setVideo_title(String video_title) {
		this.video_title = video_title;
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
		return "Condition [video_title=" + video_title + ", speaker_name=" + speaker_name + ", course_name="
				+ course_name + ", speaker_job=" + speaker_job + ", page=" + page + ", item=" + item + ", ids=" + ids
				+ "]";
	}




	



	


	
	
}
