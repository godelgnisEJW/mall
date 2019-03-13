package com.mall.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.mall.bean.Cart;
@Mapper
public interface CartDao {
	/**
	 * 通过加入购物车的序列号查询一条购物车记录
	 * @param serialNum加入购物车的序列号
	 * @return
	 */
	@Select("select * from cart where serial_num = #{serial_num}")
	@Results({
		@Result(id = true, column = "serial_num", property = "serialNum"),
		@Result(column = "pro_id", property = "proId"),
		@Result(column = "user_id", property = "userId"),
		@Result(column = "count_to_add", property = "countToAdd"),
		@Result(column = "time_to_add", property = "timeToAdd"),
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
}
