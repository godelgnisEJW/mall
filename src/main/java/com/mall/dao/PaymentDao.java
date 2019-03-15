package com.mall.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mall.model.Payment;

@Mapper
public interface PaymentDao {

	/**
	 * 添加银行卡记录
	 * @param payment
	 * @return
	 */
	@Insert("insert into * payment(user_id, card_type, card_nnum) values(#{user_id}, #{card_type}, #{card_num})")
	@Options(useGeneratedKeys = true, keyProperty = "paymentId", keyColumn = "payment_id")
	public int insertPayment(Payment payment);
	
	/**
	 * 删除银行卡记录
	 * @param paymentId
	 */
	@Delete("delete from payment where payment_id = #{payment_id}")
	public void deleteByPaymentId(@Param("payment_id")Integer paymentId);
	
	/**
	 * 通过支付Id查找相应的银行卡记录
	 * @param paymentId
	 * @return
	 */
	@Select("select * from payment where payment_id = #{payment_id")
	public Payment selecetByPaymentId(@Param("payment_id")Integer paymentId);
	
	/**
	 * 通过用户Id查找用户拥有的所有银行卡
	 * @param userId
	 * @return
	 */
	@Select("select * from payment where user_id = #{user_id}")
	public ArrayList<Payment> selectByUserId(@Param("user_id")Integer userId);
}
