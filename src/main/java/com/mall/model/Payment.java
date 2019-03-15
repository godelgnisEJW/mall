package com.mall.model;

import java.io.Serializable;

public class Payment implements Serializable{
	//支付ID
	private Integer paymentId;
	//用户ID
	private Integer userId;
	//银行卡类型“工商银行”，“建设银行”，“广发银行”，“交通银行”，“中国银行”
	private String cardType;
	//银行卡号
	private String cardNum;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
	
}
