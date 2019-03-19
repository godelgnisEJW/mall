package com.mall.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Cart implements Serializable{
	//用户ID
	private Integer userId;
	//商品ID
	private Integer proId;
	//添加数量
	private Integer countToAdd;
	//添加时间,时间格式化
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date timeToAdd;
	//购物序列号
	private Integer serialNum;
	
	//商品信息
	private  ProInfo proInfo;
	
	public ProInfo getProInfo() {
		return proInfo;
	}
	public void setProInfo(ProInfo proInfo) {
		this.proInfo = proInfo;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public Integer getCountToAdd() {
		return countToAdd;
	}
	public void setCountToAdd(Integer countToAdd) {
		this.countToAdd = countToAdd;
	}
	public Date getTimeToAdd() {
		return timeToAdd;
	}
	public void setTimeToAdd(Date timeToAdd) {
		this.timeToAdd = timeToAdd;
	}
	public Integer getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}
	
	
	
}
