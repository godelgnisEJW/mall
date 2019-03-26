package com.mall.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.model.Message;
import com.mall.model.RecipientInfo;
import com.mall.service.RecipientInfoService;

@RestController
@RequestMapping("/recipientinfo")
public class RecipientInfoController {
	
	@Autowired
	RecipientInfoService recipientInfoService;
	
	@PostMapping("/add")
	public Message add(@RequestBody RecipientInfo recipientInfo) {
		Message message = new Message();
		try {
			recipientInfoService.add(recipientInfo);
			message.setMessage("添加成功");
			message.getOptionParam().put("addressId", recipientInfo.getAddressId());
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			message.setMessage("添加失败");
			return message;
		}
	}
	
	@DeleteMapping("/delete/{addressId}")
	public Message delete(@PathVariable("addressId") int addressId) {
		Message message = new Message();
		try {
			recipientInfoService.delete(addressId);
			message.setMessage("删除成功");
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			message.setMessage("删除失败");
			return message;
		}
	}
	
	@GetMapping("/find/{userId}")
	public ArrayList<RecipientInfo> findByUserId(@PathVariable("userId") int userId) {
		ArrayList<RecipientInfo> list = recipientInfoService.selectByUserId(userId);
		return list;
	}
	@PutMapping("/modify")
	public Message modify(@RequestBody RecipientInfo recipientInfo) {
		Message message = new Message();
		try {
			recipientInfoService.update(recipientInfo);
			message.setMessage("修改成功");
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			message.setMessage("修改失败");
			return message;
		}
	}
}
