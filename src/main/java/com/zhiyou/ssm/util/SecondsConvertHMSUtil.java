package com.zhiyou.ssm.util;

public class SecondsConvertHMSUtil {
	//传秒转换成hh:mm:ss
	/*public static String caluateTime(int video_length) {
		int video_length_s = 0; // 秒  video_length%60
		int video_length_m = 0; // 分钟  video_length%3600/60
		int video_length_h = 0; // 小时  video_length/3600
		video_length_s = video_length % 60;  //0
		int j = video_length / 60;  //120
		if (j >= 60) {
			video_length_m = j % 60;  //0
			int k = j / 60;  //2
			video_length_h = k;
		} else {
			video_length_m = j;
		}
		String sf = "";
		sf = caluateHMS(sf,video_length_h) + ":";
		sf = caluateHMS(sf,video_length_m) + ":";
		sf = caluateHMS(sf,video_length_s);		
		return sf;
	}*/
	public static String caluateTime(int video_length) {
		int video_length_s = video_length%60; // 秒  
		int video_length_m = video_length%3600/60; // 分钟  
		int video_length_h = video_length/3600; // 小时 	
		String sf = caluateHMS(video_length_h)+ ":"+caluateHMS(video_length_m)+":"+caluateHMS(video_length_s);
		return sf;
	}
	//计算时分秒
	/*public static String caluateHMS(String str,int num){
		if(num<10){
			str += "0"+num;
		}else{
			str += ""+num;
		}
		System.out.println(str);
		return str;
	}*/
	public static String caluateHMS(int num){
		String str = "";
		if(num<10){
			str = "0"+num;
		}else{
			str = ""+num;
		}
		System.out.println(str);
		return str;
	}
}
