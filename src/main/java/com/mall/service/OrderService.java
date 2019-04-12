package com.mall.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.dao.CartDao;
import com.mall.dao.OrderDao;
import com.mall.dao.ProInfoDao;
import com.mall.model.Order;
import com.mall.model.ProInfo;

/**
 * 订单管理模块：订单的增、查、改(仅修改订单的签收状态和支付状态)
 * @author wang
 */
@Service
public class OrderService {
	
	@Autowired
	OrderDao orderDao;
	@Autowired
	ProInfoDao proInfoDao;
	@Autowired
	CartDao cartDao;
	
	//增加订单
	public void addOrder(Order order){
		int proId = order.getProId();
		ProInfo proInfo = proInfoDao.selectByProId(proId);
		int stock = proInfo.getStock() - order.getCountToOrder();
		ProInfo newProInfo = new ProInfo();
		newProInfo.setStock(stock);
		newProInfo.setProId(proId);
		//更新库存
		proInfoDao.updateWithProInfo(newProInfo);
		//删除购物车中相应的记录
		Integer serialNum = order.getSerialNum();
		if(serialNum != null && serialNum > 0) {
			cartDao.deleteCart(serialNum);
		}
		orderDao.insertOrder(order);
	}
	
	//通过订单序列号查询订单
	public Order selectOrderByOrderNum(Integer orderNum){
		return orderDao.selectByOrderNum(orderNum);
	}
	
	//通过用户Id查询订单
	public ArrayList<Order> selectOrdersByUserId(Integer userId){
		return orderDao.selectByUserId(userId);
	}
	
	//查询所有订单
	public ArrayList<Order> selectAll(){
		return orderDao.selectAll();
	}
	
	//更改订单支付状态
	public void updateStatusOfPayment(Integer orderNum){
		orderDao.updateIsPayed(true, orderNum);
	}
	
	//更改订单签收状态
	public void updateStatusOfSigning(Integer orderNum) {
		orderDao.updateIsSigned(true, orderNum);
	}
	//更新订单信息
	public void updateLogisticsInfo(String expCode, String expressNum, Integer orderNum) {
		orderDao.updateLogisticsInfo(expCode, expressNum, orderNum);
	}
}
