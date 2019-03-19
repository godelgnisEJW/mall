package com.mall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.model.Cart;
import com.mall.model.Message;
import com.mall.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/all")
	public ArrayList<Cart> selectAll(){
		return cartService.selectAll();
	}
	
	/**
	 * 查询用户所有的购物车记录
	 * @param userId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/find/{userId}")
	public PageInfo<Cart> selectByUserId(@PathVariable("userId")int userId,
					@RequestParam(value = "pageNum" ,required = false)Integer pageNum, 
					@RequestParam(value = "pageSize" ,required = false)Integer pageSize){
		if (pageNum != null && pageSize != null) {
			PageHelper.startPage(pageNum, pageSize);
		}
		List<Cart> carts = cartService.selectByUserId(userId);
		PageInfo<Cart> carPageInfo = new PageInfo<>(carts);
		return carPageInfo;
	}
	/**
	 * 添加一条购物车记录
	 * @param cart
	 * @return
	 */
	@PostMapping("/add")
	public Message add(@RequestBody Cart cart) {
		Message message = new Message();
		try {
			cartService.add(cart);
			message.setMessage("添加成功");
			message.getOptionParam().put("serialNum", cart.getSerialNum());
			return message;
		} catch (Exception e) {
			message.setMessage("添加失败");
			return message;
		}
	}
	/**
	 * 修改购物数量
	 * @param countToAdd
	 * @param serialNum
	 * @return
	 */
	@PutMapping("/modify")
	public Message modify(@RequestBody Map<String, Object> map) {
		Message message = new Message();
		try {
			cartService.modify((int)map.get("countToAdd"), (int)map.get("serialNum"));
			message.setMessage("修改成功");
			return message;
		} catch (Exception e) {
			message.setMessage("修改失败");
			return message;
		}
	}
}


