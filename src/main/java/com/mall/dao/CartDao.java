package com.mall.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mall.model.Cart;
@Mapper
public interface CartDao {
	/**
	 * 通过加入购物车的序列号查询一条购物车记录
	 * @param serialNum加入购物车的序列号
	 * @return
	 */
	@Select("select * from cart where serial_num = #{serialNum}")
	@Results({
		@Result(column = "pro_id", property = "proId"),
		@Result(column = "pro_id", property = "proInfo",
				one = @One(
						select = "com.mall.dao.ProInfoDao.selectByProId"))
	})
	public Cart selectBySerialNum(Integer serialNum);
	@Select("select * from cart")
	@Results({
		@Result(column = "pro_id", property = "proId"),
		@Result(column = "pro_id", property = "proInfo",
				one = @One(
						select = "com.mall.dao.ProInfoDao.selectByProId"))
	})
	public ArrayList<Cart> selectAll();
	
	/**
	 * 通过用户Id查询该用户所有加入购车的商品信息
	 * @param userId
	 * @return
	 */
	@Select("select * from cart where user_id = #{userId}")
	public ArrayList<Cart> selectByUserId(Integer userId);
	
	/**
	 * 添加一条购物车信息
	 * @param cart
	 * @return
	 */
	@Insert("insert cart(user_id, pro_id, count_to_add, time_to_add) values(#{userId}, #{proId}, #{countToAdd}, #{timeToAdd})")
	@Options(useGeneratedKeys = true, keyProperty = "serialNum", keyColumn = "serial_num")
	public int insertCart(Cart cart);
	
	/**
	 * 
	 * @param serialNum
	 */
	@Delete("delete from cart where serial_num = #{serialNum}")
	public void deleteCart(Integer serialNum);
	
	/**
	 * 更改加入购物车中的对应serial_num的商品的购物数量
	 * @param countToAdd
	 * @param serialNum
	 */
	@Update("update cart set count_to_add = #{countToAdd} where serial_num = #{serialNum}")
	public void updateCountToAdd(Integer countToAdd, Integer serialNum);
	
}
