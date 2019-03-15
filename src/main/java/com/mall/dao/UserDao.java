package com.mall.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.mall.model.User;

@Mapper
public interface UserDao {
	/**
	 * 通过用户名查询用户记录
	 * @param userName
	 * @return
	 */
	@Select("select * from user where user_name = #{user_name}")
	public User selectByUserName(@Param("user_name")String userName);
	
	/**
	 * 通过手机号码查询用户记录
	 * @param phone
	 * @return
	 */
	@Select("select * from user where phone = #{phone}")
	public User selectByPhone(@Param("phone")String phone);
	
	/**
	 * 查询所有的用户记录
	 * @return
	 */
	@Select("select * from user")
	public ArrayList<User> selectAll();
	
	/**
	 * 添加新的用户信息
	 * @param user
	 * @return
	 */
	@Insert("insert into user(user_name, user_name, user_name, phone, mail)"
			+ "values(#{user_name}, #{user_name}, #{user_name}, #{phone}, #{mail})")
	@Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
	public int insertUser(User user);
	
	/**
	 * 删除用户信息
	 * @param userId 用户Id
	 */
	@Delete("delete * from user where user_id = #{user_id}")
	public void delete(@Param("user_id")Integer userId);
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	@Update("update user set user_name = #{user_name}, password = #{password}, user_type = {user_type}, phone = #{phone}, mail = #{mail} where user_id = #{user_id}")
	public void update(User user);
	
	/**
	 * 动态查询
	 * @param params
	 * @return
	 */
	@SelectProvider(method = "selectWithParams", type = com.mall.dynamicSql.UserDynaSqlProvider.class)
	public User selectWithParams(Map<String, Object> params);
	
	/**
	 * 动态更新
	 * @param params
	 * @return
	 */
	@UpdateProvider(method = "updateWithParams", type = com.mall.dynamicSql.UserDynaSqlProvider.class)
	public User updateWithParams(Map<String, Object> params);
	
	/**
	 * 动态插入
	 * @param params
	 * @return
	 */
	@InsertProvider(method = "insertWithParams", type = com.mall.dynamicSql.UserDynaSqlProvider.class)
	public User insertWithParams(Map<String, Object> params);
}
