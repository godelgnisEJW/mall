package com.mall.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.mall.model.Message;
import com.mall.model.Product;
import com.mall.model.RecipientInfo;
import com.mall.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/putOnSale")
	public Message putOnSale(@RequestBody Product product) {
		Message message = new Message();
		try {
			productService.putOnSale(product);
			message.setMessage("上新成功");
			return message;
		} catch (Exception e) {
			message.setMessage("上新失败");
			return message;
		}
	}
	
	@PutMapping("/pullOffShelves/upperId={upperId}")
	public Message pullOffShelves(@PathVariable Integer upperId){
		Message message = new Message();
		try {
			productService.pullOffShelves(upperId);
			message.setMessage("下架成功");
			return message;
		} catch (Exception e) {
			message.setMessage("下架失败");
			return message;
		}
	}

	@GetMapping("/get/upperId={upperId}")
	public Product getByUpperId(@PathVariable Integer upperId){
		return productService.selectByUpperId(upperId);
	}
	
	@GetMapping("/get/brand={brand}")
	public ArrayList<Product> getByBrand(@PathVariable String brand){
		return productService.selectByBrand(brand);
	}

	@GetMapping("/get/title={title}")
	public ArrayList<Product> getByTitle(@PathVariable String title){
		return productService.selectByTitle(title);
	}
	
	@GetMapping("/get")
	public PageInfo<Product> getByCategory(
			@RequestParam(value = "category", required = false)String category,
			@RequestParam(value = "title", required = false)String title,
			@RequestParam(value = "pageNum")Integer pageNum, 
			@RequestParam(value = "pageSize")Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Product> products = null;
		try {
			if (category == null || title == null) {
				if (category == null && title == null) {
					products = productService.selectByCategory("手机");
				}else if(title == null){
					products = productService.selectByCategory(category);
				}else {
					products = getByTitle(title);
				}
			}else {
				products = productService.selectByTitleAndCategory(category, title);
			}
		} catch (Exception e) {
			products = productService.selectByCategory("手机");
		}
		PageInfo<Product> productsPageInfo = new PageInfo<>(products);
		return productsPageInfo;
		
	}
	
	@PutMapping("/update")
	public Message update(@RequestBody Product product){
		Message message = new Message();
		try {
			productService.update(product);
			message.setMessage("更新成功");
			return message;
		} catch (Exception e) {
			message.setMessage("更新失败");
			return message;
		}
	}
	@PostMapping("/add")
	public Message add(@RequestBody Product product) {
		Message message = new Message();
		try {
			productService.add(product);
			message.setMessage("添加成功");
			return message;
		} catch (Exception e) {
			message.setMessage("添加失败");
			return message;
		}
	}
	
}
