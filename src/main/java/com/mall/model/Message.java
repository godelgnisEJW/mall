package com.mall.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Message implements Serializable{
	private String message;
	private Map<String, Object> optionParam = new HashMap<>();
	public Message() {
		
	}
	
	public Map<String, Object> getOptionParam() {
		return optionParam;
	}

	public void setOptionParam(Map<String, Object> optionParam) {
		this.optionParam = optionParam;
	}

	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
