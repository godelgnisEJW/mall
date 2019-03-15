package com.mall.dynamicSql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ProInfoDynaSqlProvider {

	/**
	 * 动态查询
	 * @param params
	 * @return
	 */
	public String selectWithParams(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("*");
				FROM("pro_info");
				if (params.get("upperId") != null) {
					WHERE(" upper_id = #{upper_id} ");
				}
				if (params.get("proId") != null) {
					WHERE(" pro_id = #{pro_id} ");
				}
				if (params.get("proName") != null) {
					WHERE(" pro_name = #{pro_name} ");
				}
				if (params.get("proType") != null) {
					WHERE(" pro_type = #{pro_type} ");
				}
				if (params.get("price") != null) {
					WHERE(" price = #{price} ");
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
				UPDATE("pro_info");
				if (params.get("upperId") != null) {
					SET(" upper_id = #{upper_id} ");
				}
				if (params.get("proName") != null) {
					SET(" pro_name = #{pro_name} ");
				}
				if (params.get("proType") != null) {
					SET(" pro_type = #{pro_type} ");
				}
				if (params.get("price") != null) {
					SET(" price = #{price} ");
				}
				if (params.get("params") != null) {
					SET(" params = #{params} ");
				}
				WHERE(" pro_id = #{pro_id} ");
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
				INSERT_INTO("pro_info");
				if (params.get("upperId") != null) {
					VALUES("upper_id", "#{upper_id}");
				}
				if (params.get("proName") != null) {
					VALUES("pro_name", "#{pro_name}");
				}
				if (params.get("proType") != null) {
					VALUES("pro_type", "#{pro_type}");
				}
				if (params.get("price") != null) {
					VALUES("price", "#{price}");
				}
				if (params.get("params") != null) {
					VALUES("params", "#{params}");
				}
			}
		}.toString();
	}
}
