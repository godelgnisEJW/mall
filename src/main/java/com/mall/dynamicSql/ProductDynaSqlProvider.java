package com.mall.dynamicSql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ProductDynaSqlProvider {
	/**
	 * 动态查询
	 * @param params
	 * @return
	 */
	public String selectWithParams(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("*");
				FROM("product");
				if (params.get("title") != null) {
					WHERE(" title = #{title} ");
				}
				if (params.get("brand") != null) {
					WHERE(" brand = #{brand} ");
				}
				if (params.get("category") != null) {
					WHERE(" category = #{category} ");
				}
				if (params.get("upperId") != null) {
					WHERE(" upper_id = #{upper_id} ");
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
				UPDATE("product");
				if (params.get("title") != null) {
					SET(" title = #{title} ");
				}
				if (params.get("brand") != null) {
					SET(" brand = #{brand} ");
				}
				if (params.get("category") != null) {
					SET(" category = #{category} ");
				}
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
				if (params.get("title") != null) {
					VALUES("title", "#{title}");
				}
				if (params.get("brand") != null) {
					VALUES("brand", "#{brand}");
				}
				if (params.get("category") != null) {
					VALUES("category", "#{category}");
				}
			}
		}.toString();
	}
}
