package com.mall.conf;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mall.dao.ImgDao;
import com.mall.model.Img;



@RunWith(SpringRunner.class)
// 这块需要引入依赖 mybatis的测试依赖jar
@MybatisTest
// 这个注解的意义是指定了默认数据源
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class ImgDaoTest {

	@Autowired
	ImgDao imgDao;
	
	@SuppressWarnings("deprecation")
	@Test
	public void insertImg() {
		Img img =  new Img();
		img.setUrl("/img/img.jpg");
		
		Logger log = LoggerFactory.getLogger(getClass());
		/*
		 * 这是我原本错误的理解，以为会返回主键id，这是错的
		 * 它只会返回影响行数
		 */
//		int id = imgDao.insertImg(img);
//		Logger log = LoggerFactory.getLogger(getClass());
//		log.info("" + id);
		
		/*
		 * 这才是正确的，insert通过 img.getImgId() 来获取主键的值
		 */
//		imgDao.insertImg(img);
//		Logger log = LoggerFactory.getLogger(getClass());
//		log.info("" + img.getImgId());
		
		/*
		 * 如果你还不放心的话，
		 * 可以试着把dao里面的@options注解那一行注释掉
		 * 然后运行以下代码，你会发现，输出null,主键值没有被封装到对象里面，
		 *这就是加不加 @Options(useGeneratedKeys= ture)的区别
		 */
//		imgDao.insertImg(img);
//		Logger log = LoggerFactory.getLogger(getClass());
//		log.info("" + img.getImgId());
		
//		ArrayList<Img> imges = imgDao.selectByUpperId(1);
//		for (Img img2 : imges) {
//			log.info("在这里！" + img2.getUrl() + ", id:" + img2.getImgId());
//		}
		
//		imgDao.deleteByImgId(3);
		img.setImgId(2);
		imgDao.updateImg(img);
		Assert.assertEquals("/img/img.jpg", imgDao.selectByImgId(2).getUrl());
	}
}