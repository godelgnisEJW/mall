package com.mall.model;

import java.io.Serializable;

public class Img implements Serializable {
	//图片路径，使用相对路径
	private String url;
	//图片ID
	private Integer imgId;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getImgId() {
		return imgId;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	
	
}
