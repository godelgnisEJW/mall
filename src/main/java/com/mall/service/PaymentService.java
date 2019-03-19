package com.mall.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.dao.PaymentDao;
import com.mall.model.Payment;

/**
 * 银行卡信息模块，进行简单的增删查改
 * @author godlegnis
 *
 */
@Service
public class PaymentService {

	@Autowired 
	
	PaymentDao paymentDao;
	/**
	 * 通过用户Id查看该用户下的所有银行卡信息
	 * @param userId
	 * @return
	 */
	public ArrayList<Payment> selectByUserId(int userId){
		return paymentDao.selectByUserId(userId);
	}
	/**
	 * 删除银行卡信息
	 * @param paymentId
	 */
	public void delete(int paymentId) {
		paymentDao.deleteByPaymentId(paymentId);
	}
	/**
	 * 添加银行卡信息
	 * @param payment
	 */
	public void add(Payment payment) {
		paymentDao.insertPayment(payment);
	}
	
}
