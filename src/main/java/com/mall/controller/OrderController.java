package com.mall.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mall.model.Message;
import com.mall.model.Order;
import com.mall.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/add")
	public Message add(@RequestBody Order order){
		Message message = new Message();
		try {
			orderService.addOrder(order);
			message.setMessage("添加订单成功");
			return message;
		} catch (Exception e) {
			message.setMessage("添加订单失败");
			return message;
		}
	}
	
	@GetMapping("/get/orderNum={orderNum}")
	public Order getByOrderNum	(@PathVariable Integer orderNum){
		return orderService.selectOrderByOrderNum(orderNum);
	}
	
	@GetMapping("/get/userId={userId}")
	public ArrayList<Order> getByUserId	(@PathVariable Integer userId){
		return orderService.selectOrdersByUserId(userId);
	}
	
	@GetMapping("/all")
	public ArrayList<Order> getAll(){
		return orderService.selectAll();
	}
	
	@PutMapping("/updateStatusOfPayment/orderNum={orderNum}")
	public Message updateStatusOfPayment(@PathVariable Integer orderNum){
		Message message = new Message();
		try {
			orderService.updateStatusOfPayment(orderNum);
			message.setMessage("修改成功");
			return message;
		} catch (Exception e) {
			message.setMessage("修改失败");
			return message;
		}
	}
	
	@PutMapping("/updateStatusOfSigning/orderNum={orderNum}")
	public Message updateStatusOfSigning(@PathVariable Integer orderNum){
		Message message = new Message();
		try {
			orderService.updateStatusOfSigning(orderNum);
			message.setMessage("修改成功");
			return message;
		} catch (Exception e) {
			message.setMessage("修改失败");
			return message;
		}
	}
	@PutMapping("/update")
	public Message updateLogisticsInfo(@RequestParam String expCode, @RequestParam String expressNum, @RequestParam int orderNum) {
		Message message = new Message();
		try {
			orderService.updateLogisticsInfo(expCode, expressNum, orderNum);
			message.setMessage("修改成功");
			return message;
		} catch (Exception e) {
			message.setMessage("修改失败");
			return message;
		}
	}
}
