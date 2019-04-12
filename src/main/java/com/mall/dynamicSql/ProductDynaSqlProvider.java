package com.mall.dynamicSql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.mall.model.Product;

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
					WHERE(" upper_id = #{upperId} ");
				}
			}
		}.toString();
	}
	
	/**
	 * 动态更新
	 * @param product
	 * @return
	 */
	public String updateWithProduct(Product product) {
		return new SQL() {
			{
				UPDATE("product");
				if (product.getTitle() != null) {
					SET(" title = #{title} ");
				}
				if (product.getBrand() != null) {
					SET(" brand = #{brand} ");
				}
				if (product.getCategory() != null) {
					SET(" category = #{category} ");
				}
				WHERE(" upper_id = #{upperId}");
			}
		}.toString();
	}
	
	/**
	 * 动态插入
	 * @param product
	 * @return
	 */
	public String insertWithProduct(Product product) {
		return new SQL() {
			{
				INSERT_INTO("product");
				if (product.getTitle() != null) {
					VALUES("title", "#{title}");
				}
				if (product.getBrand() != null) {
					VALUES("brand", "#{brand}");
				}
				if (product.getCategory() != null) {
					VALUES("category", "#{category}");
				}
				WHERE(" upper_id = #{upperId} ");
			}
		}.toString();
	}
}
