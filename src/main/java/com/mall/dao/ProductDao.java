package com.mall.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.mall.model.Product;
import com.mall.model.User;

@Mapper
public interface ProductDao {
	/**
	 * 通过上架号查询商品信息
	 * @param upperId
	 */
	@Select("select * from  product where upper_id = #{upper_id}")
	@Results({
		@Result(column = "upper_id", property = "upperId"),
		@Result(column = "upper_id", property = "imges",
				many = @Many(
						select = "com.mall.dao.ImgDao.selectByUpperId")),
		@Result(column = "upper_id", property = "proInfoes",
				many = @Many(
						select = "com.mall.dao.ProInfoDao.selectByUpperId"))
	})
	public Product selectByUppderId(@Param("upper_id")Integer upperId);
	
	/**
	 * 模糊查询，通过商品标题进行模糊查询
	 * @param title
	 * @return
	 */
	@Select("select * from  product where title like CONCAT('%',#{title},'%')")
	@Results({
		@Result(column = "upper_id", property = "upperId"),
		@Result(column = "upper_id", property = "imges",
				many = @Many(
						select = "com.mall.dao.ImgDao.selectByUpperId")),
		@Result(column = "upper_id", property = "proInfoes",
				many = @Many(
						select = "com.mall.dao.ProInfoDao.selectByUpperId"))
	})
	public ArrayList<Product> selectByTitle(@Param("title")String title);
	
	/**
	 * 通过品牌查询商品
	 * @param brand
	 * @return
	 */
	@Select("select * from  product where brand = #{brand}")
	@Results({
		@Result(column = "upper_id", property = "upperId"),
		@Result(column = "upper_id", property = "imges",
				many = @Many(
						select = "com.mall.dao.ImgDao.selectByUpperId")),
		@Result(column = "upper_id", property = "proInfoes",
				many = @Many(
						select = "com.mall.dao.ProInfoDao.selectByUpperId"))
	})
	public ArrayList<Product> seleByBrand(@Param("brand")String brand);
	
	/**
	 * 通过商品种类查询相关商品
	 * @param category
	 * @return
	 */
	@Select("select * from product where category = #{category}")
	@Results({
		@Result(column = "upper_id", property = "upperId"),
		@Result(column = "upper_id", property = "imges",
				many = @Many(
						select = "com.mall.dao.ImgDao.selectByUpperId")),
		@Result(column = "upper_id", property = "proInfoes",
				many = @Many(
						select = "com.mall.dao.ProInfoDao.selectByUpperId"))
	})
	public ArrayList<Product> selectByCategory(@Param("category")String category);
	
	/**
	 * 插入一条商品信息
	 * @param product
	 * @return
	 */
	@Insert("insert into product(title, brand, category) vales(#{title}, #{brand}, #{category})")
	 @Options(useGeneratedKeys = true, keyProperty = "upperId", keyColumn = "upper_id")
	public int insertProduct(Product product);
	
	/**
	 * 通过上架号删除商品记录
	 * @param upperId
	 */
	@Delete("delete from product where upper_id = #{upper_id}")
	public void deleteProduct(@Param("upper_id")String upperId);
	
	/**
	 * 更新商品信息
	 * @param product
	 */
	@Update("update product set "
			+ "title = #{title}, "
			+ "brand = #{brand}, "
			+ "category = #{category}")
	public void updateProduct(Product product);
	
	
	/**
	 * 动态查询
	 * @param params
	 * @return
	 */
	@SelectProvider(method = "selectWithParams", type = com.mall.dynamicSql.ProductDynaSqlProvider.class)
	public User selectWithParams(Map<String, Object> params);
	
	/**
	 * 动态更新
	 * @param params
	 * @return
	 */
	@UpdateProvider(method = "updateWithParams", type = com.mall.dynamicSql.ProductDynaSqlProvider.class)
	public User updateWithParams(Map<String, Object> params);
	
	/**
	 * 动态插入
	 * @param params
	 * @return
	 */
	@InsertProvider(method = "insertWithParams", type = com.mall.dynamicSql.ProductDynaSqlProvider.class)
	public User insertWithParams(Map<String, Object> params);
}
