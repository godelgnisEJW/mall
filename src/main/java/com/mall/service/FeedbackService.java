package com.mall.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.dao.FeedbackDao;
import com.mall.model.Feedback;

/**
 * 用户反馈服务
 * @author godlegnis
 *
 */
@Service
public class FeedbackService {
	
	@Autowired
	FeedbackDao feedbackDao;
	
	@Autowired
	ImgService imgService;
	/**
	 * 提交一条反馈记录
	 * @param feedback
	 */
	public void submit(Feedback feedback) {
		feedbackDao.insertFeedback(feedback);
	}
	/**
	 * 删除一条反馈记录
	 * @param feedback
	 */
	public void delete(Feedback feedback) {
		feedbackDao.deleteFeedback(feedback.getFbId());
		imgService.deleteImg(feedback.getImg());
	}
	/**
	 * 查询所有的反馈记录
	 * @return
	 */
	public ArrayList<Feedback> selectAll() {
		return feedbackDao.selectAll();
	}
	/**
	 * 通过用户Id查询该用户的所有反馈记录
	 * @param userId
	 * @return
	 */
	public ArrayList<Feedback> selectByUserId(int userId){
		return feedbackDao.selectAllByUserId(userId);
	}
	
}
