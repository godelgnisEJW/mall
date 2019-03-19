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
	/**
	 * 查询所有的购物车记录
	 * @return
	 */
	public ArrayList<Cart> selectAll() {
		return cartDao.selectAll();
	}
	/**
	 * 添加一条购物车记录
	 * @param cart
	 * @return
	 */
	public int add(Cart cart) {
		return cartDao.insertCart(cart);
	}
	/**
	 * 删除一天购物车记录
	 * @param serialNum
	 */
	public void delete(int serialNum) {
		cartDao.deleteCart(serialNum);
	}
	/**
	 * 查询用户的所有购物车记录
	 * @param userId
	 * @return
	 */
	public ArrayList<Cart> selectByUserId(int userId) {
		return cartDao.selectByUserId(userId);
	}
	/**
	 * 更新购车记录的中某件商品的数量
	 * @param countToAdd
	 * @param serialNum
	 */
	public void modify(int countToAdd, int serialNum) {
		cartDao.updateCountToAdd(countToAdd, serialNum);
	}
}
