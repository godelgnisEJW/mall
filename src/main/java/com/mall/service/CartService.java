package com.mall.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.dao.CartDao;
import com.mall.dao.ImgDao;
import com.mall.model.Cart;
import com.mall.model.Img;
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
}
