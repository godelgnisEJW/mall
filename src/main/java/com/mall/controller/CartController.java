package com.mall.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.model.Cart;
import com.mall.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/")
	public Cart test() {
		return cartService.selectBySerialNum(1);
	}
	
	@RequestMapping("/all")
	public ArrayList<Cart> selectAll(){
		return cartService.selectAll();
	}
}
