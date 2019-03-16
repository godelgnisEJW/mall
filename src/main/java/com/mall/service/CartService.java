package com.mall.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.dao.CartDao;
import com.mall.model.Cart;

/**
 * 购物车服务，分别对购物车进行增删查操作
 * @author godlegnis
 *
 */
@Service
public class CartService {
	@Autowired
	private CartDao cartDao;
	
	public Cart selectBySerialNum(Integer serialNum) {
		return cartDao.selectBySerialNum(serialNum);
	};
	
	public ArrayList<Cart> selectAll() {
		return cartDao.selectAll();
	}
	
	//写一个分页查询
}
