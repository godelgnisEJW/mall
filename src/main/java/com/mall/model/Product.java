package com.mall.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
	//标题
	private String title;
	//品牌
	private String brand;
	//商品种类
	private String category;
	//上架ID
	private Integer upperId;
	//状态：在售、已下架
	private String status;
	
	//商品详情图片
	private ArrayList<Img> imges;
	
	private ArrayList<ProInfo> proInfoes;
	
	
	public ArrayList<ProInfo> getProInfoes() {
		return proInfoes;
	}

	public void setProInfoes(ArrayList<ProInfo> proInfoes) {
		this.proInfoes = proInfoes;
	}

	public ArrayList<Img> getImges() {
		return imges;
	}

	public void setImges(ArrayList<Img> imges) {
		this.imges = imges;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getUpperId() {
		return upperId;
	}

	public void setUpperId(Integer upperId) {
		this.upperId = upperId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
