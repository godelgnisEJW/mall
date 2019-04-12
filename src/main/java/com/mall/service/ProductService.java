package com.mall.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.dao.DetailImgMidDao;
import com.mall.dao.ProInfoDao;
import com.mall.dao.ProductDao;
import com.mall.dao.ShowImgMidDao;
import com.mall.model.DetailImgMid;
import com.mall.model.Img;
import com.mall.model.ProInfo;
import com.mall.model.Product;
import com.mall.model.ShowImgMid;

/**
 * 后台商品的管理：商品的上新、下架、搜索、更新
 * 1.上新：插入新的商品信息
 * 2.下架：将对应商品的status属性设置为 "已下架"
 * 3.搜索：根据商品的brand,upperId,title,category进行模糊搜索
 * 4.更新：动态更新商品信息
 * @author wang
 *
 */

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;
	@Autowired
	ProInfoDao proInfoDao;
	@Autowired
	DetailImgMidDao detailImgMidDao;
	@Autowired
	ShowImgMidDao showImgMidDao;
	
	//商品上新
	public void putOnSale(Product product){
		product.setStatus("在售");
		productDao.insertProduct(product);
	}
	
	//下架商品
	//1.找到对应upperId的商品
	//2.将status设置为“已下架”
	//3.更新
	public void pullOffShelves(Integer upperId){
		Product product = productDao.selectByUppderId(upperId);
		product.setStatus("已下架");
		productDao.updateProduct(product);
	}
	
	public ArrayList<Product> selectByTitleAndCategory(String category ,String title){
		return productDao.selectByTitleAndCategory(category, title);
	}
	
	//通过品牌查找商品
	public ArrayList<Product> selectByBrand(String brand){
		return productDao.seleByBrand(brand);
	}
	//通过商品上架Id查找商品
	public Product selectByUpperId(Integer upperId){
		return productDao.selectByUppderId(upperId);
	}
	//通过商品标题进行模糊查询
	public ArrayList<Product> selectByTitle(String title){
		return productDao.selectByTitle(title);
	}
	//通过商品种类进行查询
	public ArrayList<Product> selectByCategory(String category){
		return productDao.selectByCategory(category);
	}
	
	//更新商品信息
	public void update(Product product){
		//动态更新
	    productDao.updateWithProduct(product);
	}
	//商品上架
	@Transactional
	public void add(Product product) {
		productDao.insertProduct(product);
		int upperId = product.getUpperId();
		ArrayList<Img> detailImges = product.getImges();
		DetailImgMid detailImgMid = new DetailImgMid();
		for (Img img : detailImges) {
			detailImgMid.setUpperId(upperId);
			detailImgMid.setImgId(img.getImgId());
			detailImgMidDao.insert(detailImgMid);
		}
		ArrayList<ProInfo> proInfoes = product.getProInfoes();
		ShowImgMid showImgMid = new ShowImgMid();
		for (ProInfo proInfo : proInfoes) {
			proInfo.setUpperId(upperId);
			proInfoDao.insertProInfo(proInfo);
			int proId = proInfo.getProId();
			showImgMid.setProId(proId);
			showImgMid.setImgId(proInfo.getImges().get(0).getImgId());
			showImgMidDao.insert(showImgMid);
		}
	}
	
}
