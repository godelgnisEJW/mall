package com.mall.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Order implements Serializable {
	//用户ID
	private Integer userId;
	//产品ID
	private Integer proId;
	//下单数量
	private Integer countToOrder;
	//下单时间,时间格式化
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date timeToOrder;
	//快递单号
	private String expressNum;
	//快递公司代号
	private String expCode;
	//收件人地址Id
	private Integer addressId;
	//订单序列号
	private Integer orderNum;
	//是否支付
	private Boolean isPayed;
	//是否签收
	private Boolean isSigned;
	//总金额
	private Double total;
	
	//收件人地址信息
	private RecipientInfo recipientInfo;
	//商品信息
	private ProInfo proInfo;
	
	//购物车Id
	private int serialNum;
	
	public int getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}
	public String getExpCode() {
		return expCode;
	}
	public void setExpCode(String expCode) {
		this.expCode = expCode;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public void setCountToOrder(Integer countToOrder) {
		this.countToOrder = countToOrder;
	}
	public RecipientInfo getRecipientInfo() {
		return recipientInfo;
	}
	public void setRecipientInfo(RecipientInfo recipientInfo) {
		this.recipientInfo = recipientInfo;
	}
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
	public Integer getCountToOrder() {
		return countToOrder;
	}
	public void setCounteToOrder(Integer countToOrder) {
		this.countToOrder = countToOrder;
	}
	public Date getTimeToOrder() {
		return timeToOrder;
	}
	public void setTimeToOrder(Date timeToOrder) {
		this.timeToOrder = timeToOrder;
	}
	public String getExpressNum() {
		return expressNum;
	}
	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public Boolean getIsPayed() {
		return isPayed;
	}
	public void setIsPayed(Boolean isPayed) {
		this.isPayed = isPayed;
	}
	public Boolean getIsSigned() {
		return isSigned;
	}
	public void setIsSigned(Boolean isSigned) {
		this.isSigned = isSigned;
	}
	
	

}
