package com.mall.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.model.Message;
import com.mall.model.Payment;
import com.mall.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/find/{userId}")
	public ArrayList<Payment> findBy(@PathVariable("userId")int userId) {
		return paymentService.selectByUserId(userId);
	}
	
	@PostMapping("/add")
	public Message add(@RequestBody Payment payment) {
		Message message = new Message();
		try {
			paymentService.add(payment);
			message.setMessage("添加成功");
			message.getOptionParam().put("paymentId", payment.getPaymentId());
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			message.setMessage("添加失败");
			return message;
		}
	}
	@DeleteMapping("/delete/{paymentId}")
	public Message delete(@PathVariable("paymentId") int paymentId) {
		Message message = new Message();
		try {
			paymentService.delete(paymentId);
			message.setMessage("删除成功");
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			message.setMessage("删除失败");
			return message;
		}
	}
}
