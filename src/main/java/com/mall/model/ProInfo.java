package com.mall.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProInfo implements Serializable {
	//上架ID
	private Integer upperId;
	//商品ID
	private Integer proId;
	//商品名称
	private String proName;
	//商品型号
	private String proType;
	//价格
	private Double price;
	//库存
	public Integer stock;
	//参数，格式为key=vlaue，用";"分隔
	private String params;
	
	//图片
	private ArrayList<Img> imges;

	public ArrayList<Img> getImges() {
		return imges;
	}
	
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public void setImges(ArrayList<Img> imges) {
		this.imges = imges;
	}

	public Integer getUpperId() {
		return upperId;
	}

	public void setUpperId(Integer upperId) {
		this.upperId = upperId;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
	
	
}
