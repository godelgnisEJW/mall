package com.mall.dynamicSql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.mall.model.ProInfo;

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
					WHERE(" upper_id = #{upperId} ");
				}
				if (params.get("proId") != null) {
					WHERE(" pro_id = #{proId} ");
				}
				if (params.get("proName") != null) {
					WHERE(" pro_name = #{proName} ");
				}
				if (params.get("proType") != null) {
					WHERE(" pro_type = #{proType} ");
				}
				if (params.get("price") != null) {
					WHERE(" price = #{price} ");
				}
				if (params.get("stock") != null) {
					WHERE(" stock = #{stock} ");
				}
			}
		}.toString();
	}
	/**
	 * 动态更新
	 * @param params
	 * @return
	 */
	public String updateWithProInfo(ProInfo proInfo) {
		return new SQL() {
			{
				UPDATE("pro_info");
				if (proInfo.getUpperId() != null) {
					SET(" upper_id = #{upperId} ");
				}
				if (proInfo.getProName() != null) {
					SET(" pro_name = #{proName} ");
				}
				if (proInfo.getProType() != null) {
					SET(" pro_type = #{proType} ");
				}
				if (proInfo.getPrice() != null) {
					SET(" price = #{price} ");
				}
				if (proInfo.getStock() != null) {
					SET(" stock = #{stock} ");
				}
				if (proInfo.getParams() != null) {
					SET(" params = #{params} ");
				}
				WHERE(" pro_id = #{proId} ");
			}
		}.toString();
	}
	
	/**
	 * 动态插入
	 * @param params
	 * @return
	 */
	public String insertWithProInfo(ProInfo proInfo) {
		return new SQL() {
			{
				INSERT_INTO("pro_info");
				if (proInfo.getUpperId() != null) {
					VALUES("upper_id", "#{upperId}");
				}
				if (proInfo.getProName() != null) {
					VALUES("pro_name", "#{proName}");
				}
				if (proInfo.getProType() != null) {
					VALUES("pro_type", "#{proType}");
				}
				if (proInfo.getPrice() != null) {
					VALUES("price", "#{price}");
				}
				if (proInfo.getStock() != null) {
					VALUES("stock", "#{stock}");
				}
				if (proInfo.getParams() != null) {
					VALUES("params", "#{params}");
				}
			}
		}.toString();
	}
}
