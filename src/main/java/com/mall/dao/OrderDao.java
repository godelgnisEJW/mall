package com.mall.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mall.model.Order;

@Mapper
public interface OrderDao {
	/**
	 * 根据订单号查询订单信息
	 * @param orderNum
	 * @return
	 */
	@Select("select * from mall.order where order_num = #{orderNum}")
	public Order selectByOrderNum(Integer orderNum);

	
	/**
	 * 根据查询所有订单
	 * @param userId
	 * @return
	 */
	@Select("select * from mall.order")
	@Results({
		@Result(property = "addressId", column = "address_id"),
		@Result(property = "proId", column = "pro_id"),
		@Result(property = "recipientInfo", column = "address_id",
			one = @One(
					select = "com.mall.dao.RecipientInfoDao.selectByAddressId")
		),
		@Result(property = "proInfo", column = "pro_id",
			one = @One(
					select = "com.mall.dao.ProInfoDao.selectByProId")
		)
	})
	public ArrayList<Order> selectAll();
	
	/**
	 * 根据用户Id查询该用户的所有订单
	 * @param userId
	 * @return
	 */
	@Select("select * from mall.order where user_id = #{userId}")
	@Results({
		@Result(property = "addressId", column = "address_id"),
		@Result(property = "proId", column = "pro_id"),
		@Result(property = "recipientInfo", column = "address_id",
			one = @One(
					select = "com.mall.dao.RecipientInfoDao.selectByAddressId")
		),
		@Result(property = "proInfo", column = "pro_id",
			one = @One(
					select = "com.mall.dao.ProInfoDao.selectByProId")
		)
	})
	public ArrayList<Order> selectByUserId(Integer userId);
	
	/**
	 * 添加新的订单记录
	 * @param order
	 * @return
	 */
	@Insert("insert into mall.order("
			+ "user_id, pro_id, count_to_order, "
			+ "time_to_order, express_num, address_id, "
			+ "is_payed, is_signed, total) "
			+ "values("
			+ "#{userId}, #{proId}, #{countToOrder}, "
			+ "#{timeToOrder}, #{expressNum}, #{addressId}, "
			+ "#{isPayed}, #{isSigned}, #{total})")
	@Options(useGeneratedKeys = true, keyProperty = "orderNum", keyColumn = "order_num")
	public int insertOrder(Order order);
	
	/**
	 * 更新订单支付标志
	 * @param isPayed
	 * @param orderNum
	 */
	@Update("update mall.order set is_payed = #{isPayed} where order_num = #{orderNum}")
	public void updateIsPayed(Boolean isPayed, Integer orderNum);
	
	/**
	 * 更新订单签收标志
	 * @param isSigned
	 * @param orderNum
	 */
	@Update("update mall.order set is_signed = #{isSigned} where order_num = #{orderNum}")
	public void updateIsSigned(Boolean isSigned, Integer orderNum);
	
	/**
	 * 更新订单快递单号和快递公司
	 * @param isSigned
	 * @param orderNum
	 */
	@Update("update mall.order set exp_code = #{expCode}, express_num = #{expressNum} where order_num = #{orderNum}")
	public void updateLogisticsInfo(String expCode, String expressNum, Integer orderNum);
}
