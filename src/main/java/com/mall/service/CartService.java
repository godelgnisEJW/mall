package com.mall.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.bean.Cart;
import com.mall.bean.Img;
import com.mall.dao.CartDao;
import com.mall.dao.ImgDao;
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
