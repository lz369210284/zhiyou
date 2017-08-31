package com.zhiyou.ssm.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Admin {

	 private Integer id;
	 	
	    private String nickName;

	    private Integer sex;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date birthday;

	    private String email;

	    private String province;

	    private String city;

	    private String headUrl;

	    private String password;

	    private Date insertTime;

	    private Date updateTime;

	    private String captcha;
	    
	    private Integer status;
	    
	    private String active_code;

	    


		public String getActive_code() {
			return active_code;
		}

		public void setActive_code(String active_code) {
			this.active_code = active_code;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }


	    public Integer getSex() {
	        return sex;
	    }

	    public void setSex(Integer sex) {
	        this.sex = sex;
	    }

	    public Date getBirthday() {
	        return birthday;
	    }

	    public void setBirthday(Date birthday) {
	        this.birthday = birthday;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email == null ? null : email.trim();
	    }

	    public String getProvince() {
	        return province;
	    }

	    public void setProvince(String province) {
	        this.province = province == null ? null : province.trim();
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city == null ? null : city.trim();
	    }

	    public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}


	    public String getCaptcha() {
	        return captcha;
	    }

	    public void setCaptcha(String captcha) {
	        this.captcha = captcha == null ? null : captcha.trim();
	    }

		public String getNickName() {
			return nickName;
		}

		public void setNickName(String nickName) {
			this.nickName = nickName;
		}

		public String getHeadUrl() {
			return headUrl;
		}

		public void setHeadUrl(String headUrl) {
			this.headUrl = headUrl;
		}

		public Date getInsertTime() {
			return insertTime;
		}

		public void setInsertTime(Date insertTime) {
			this.insertTime = insertTime;
		}

		public Date getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}

		@Override
		public String toString() {
			return "Admin [id=" + id + ", nickName=" + nickName + ", sex=" + sex + ", birthday=" + birthday + ", email="
					+ email + ", province=" + province + ", city=" + city + ", headUrl=" + headUrl + ", password="
					+ password + ", insertTime=" + insertTime + ", updateTime=" + updateTime + ", captcha=" + captcha
					+ ", status=" + status + ", active_code=" + active_code + "]";
		}

	

		
}
