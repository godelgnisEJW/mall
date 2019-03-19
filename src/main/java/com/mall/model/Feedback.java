package com.mall.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Feedback implements Serializable{

	//反馈ID
	private Integer fbId;
	//用户ID
	private Integer userId;
	//反馈内容
	private String fbContent;
	//反馈时间,时间格式化
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date fbTime;
	//图片ID
	private Integer imgId;
	
	//图片
	private Img img;
	
	public Img getImg() {
		return img;
	}
	public void setImg(Img img) {
		this.img = img;
	}
	public Integer getFbId() {
		return fbId;
	}
	public void setFbId(Integer fbId) {
		this.fbId = fbId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFbContent() {
		return fbContent;
	}
	public void setFbContent(String fbContent) {
		this.fbContent = fbContent;
	}
	public Date getFbTime() {
		return fbTime;
	}
	public void setFbTime(Date fbTime) {
		this.fbTime = fbTime;
	}
	public Integer getImgId() {
		return imgId;
	}
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	
	
}
