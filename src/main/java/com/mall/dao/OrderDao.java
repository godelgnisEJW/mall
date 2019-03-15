package com.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mall.model.Order;

@Mapper
public interface OrderDao {
	/**
	 * 根据订单号查询订单信息
	 * @param orderNum
	 * @return
	 */
	@Select("select * from order where order_num = #{order_num}")
	public Order selectByOrderNum(@Param("order_num")Integer orderNum);

	/**
	 * 根据用户Id查询该用户的所有订单
	 * @param userId
	 * @return
	 */
	@Select("select * from order where user_id = #{user_id}")
	@Results({
		@Result(property = "userId", column = "user_id"),
		@Result(property = "proId", column = "pro_id"),
		@Result(property = "userId", column = "user_id",
			one = @One(
					select = "com.mall.dao.RecipientInfoDao.selectByUserId")
		),
		@Result(property = "proId", column = "pro_id",
			one = @One(
					select = "com.mall.dao.ProInfoDao.selectByProId")
		)
	})
	public List<Order> selectByUserId(@Param("user_id")Integer userId);
	
	/**
	 * 添加新的订单记录
	 * @param order
	 * @return
	 */
	@Insert("insert into order("
			+ "user_id, pro_id, count_to_order, "
			+ "time_to_order, express_num, address_id, "
			+ "is_payed, is_signed) "
			+ "values("
			+ "#{user_id}, #{pro_id}, #{count_to_order}, "
			+ "#{time_to_order}, #{express_num}, #{address_id}, "
			+ "#{is_payed}, #{is_signed})")
	@Options(useGeneratedKeys = true, keyProperty = "orderNum", keyColumn = "order_num")
	public int insertOrder(Order order);
	
	
}
