package com.mall.dynamicSql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

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
					WHERE(" user_name = #{user_name} ");
				}
				if (params.get("phone") != null) {
					WHERE(" phone = #{phone} ");
				}
				if (params.get("mail") != null) {
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
	public String updateWithParams(Map<String, Object> params) {
		return new SQL() {
			{
				UPDATE("user");
				if (params.get("userName") != null) {
					SET(" user_name = #{user_name} ");
				}
				if (params.get("password") != null) {
					SET(" password = #{password} ");
				}
				if (params.get("userType") != null) {
					SET(" user_type = #{user_type} ");
				}
				if (params.get("phone") != null) {
					SET(" phone = #{phone} ");
				}
				if (params.get("mail") != null) {
					SET(" mail = #{mail} ");
				}
				WHERE(" user_id = #{user_id} ");
			}
		}.toString();
	}
	
	/**
	 * 动态插入
	 * @param params
	 * @return
	 */
	public String insertWithParams(Map<String, Object> params) {
		return new SQL() {
			{
				INSERT_INTO("user");
				if (params.get("userName") != null) {
					VALUES("user_name", "#{user_name}");
				}
				if (params.get("password") != null) {
					VALUES("password", "#{password}");
				}
				if (params.get("userType") != null) {
					VALUES("user_type", "#{user_type}");
				}
				if (params.get("phone") != null) {
					VALUES("phone", "#{phone}");
				}
				if (params.get("mail") != null) {
					VALUES("mail", "#{mail}");
				}
			}
		}.toString();
	}
}
