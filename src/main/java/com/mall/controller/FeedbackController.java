package com.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.model.Feedback;
import com.mall.model.Message;
import com.mall.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	/**
	 * 提交一条反馈记录
	 * @param feedback
	 */
	@PostMapping("/submit")
	public Message submit(@RequestBody Feedback feedback) {
		try {
			feedbackService.submit(feedback);
			return new Message("提交成功");
		} catch (Exception e) {
			return new Message("提交失败");
		}
	}
	/**
	 * 删除一条反馈记录
	 * @param feedback
	 */
	@DeleteMapping("/delete")
	public void delete(@RequestBody Feedback feedback) {
		feedbackService.delete(feedback);
	}
	/**
	 * 查询所有的反馈记录
	 * @return
	 */
	@GetMapping("/all")
	public PageInfo<Feedback> selectAll(
					@RequestParam(value = "pageNum" ,required = false)Integer pageNum, 
					@RequestParam(value = "pageSize" ,required = false)Integer pageSize) {
		if (pageNum != null && pageSize != null) {
			PageHelper.startPage(pageNum, pageSize);
		}
		List<Feedback> fbList = feedbackService.selectAll();
		PageInfo<Feedback> fbPageInfo = new PageInfo<>(fbList);
		return fbPageInfo;
	}
	/**
	 * 通过用户Id查询该用户的所有反馈记录
	 * @param userId
	 * @return
	 */
	@GetMapping("/all/{userId}")
	public PageInfo<Feedback> selectByUserId(@PathVariable("userId")int userId,
					@RequestParam(value = "pageNum" ,required = false)Integer pageNum, 
					@RequestParam(value = "pageSize" ,required = false)Integer pageSize){
		if (pageNum != null && pageSize != null) {
			PageHelper.startPage(pageNum, pageSize);
		}
		List<Feedback> fbList = feedbackService.selectByUserId(userId);
		PageInfo<Feedback> fbPageInfo = new PageInfo<>(fbList);
		return fbPageInfo;
	}
}
