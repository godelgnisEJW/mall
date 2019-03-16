package com.mall.dynamicSql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.mall.model.User;

public class UserDynaSqlProvider {
	/**
	 * 动态查询
	 * @param params
	 * @return
	 */
	public String selectWithParams(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("*");
				FROM("user");
				if (params.get("userName") != null) {
					WHERE(" user_name = #{userName} ");
				}
				else if (params.get("phone") != null) {
					WHERE(" phone = #{phone} ");
				}
				else if (params.get("mail") != null) {
					WHERE(" mail = #{mail} ");
				}
			}
		}.toString();
	}
	/**
	 * 动态更新
	 * @param params
	 * @return
	 */
	public String updateWithUser(User user) {
		return new SQL() {
			{
				UPDATE("user");
				if (user.getUserName() != null) {
					SET(" user_name = #{userName} ");
				}
				if (user.getPassword() != null) {
					SET(" password = #{password} ");
				}
				if (user.getUserType() != null) {
					SET(" user_type = #{userType} ");
				}
				if (user.getPhone() != null) {
					SET(" phone = #{phone} ");
				}
				if (user.getMail() != null) {
					SET(" mail = #{mail} ");
				}
				WHERE(" user_id = #{userId} ");
			}
		}.toString();
	}
	
	/**
	 * 动态插入
	 * @param params
	 * @return
	 */
	public String insertWithUser(User user) {
		return new SQL() {
			{
				INSERT_INTO("user");
				if (user.getUserName() != null) {
					VALUES("user_name", "#{userName}");
				}
				if (user.getPassword() != null) {
					VALUES("password", "#{password}");
				}
				if (user.getUserType() != null) {
					VALUES("user_type", "#{userType}");
				}
				if (user.getPhone() != null) {
					VALUES("phone", "#{phone}");
				}
				if (user.getMail() != null) {
					VALUES("mail", "#{mail}");
				}
			}
		}.toString();
	}
}
