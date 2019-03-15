package com.mall.dynamicSql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class RecipientInfoDynaSqlProvider {
	
	/**
	 * 动态更新
	 * @param params
	 * @return
	 */
	public String updateWithParams(Map<String, Object> params) {
		return new SQL() {
			{
				UPDATE("recipient_info");
				if (params.get("province") != null) {
					SET(" province = #{province} ");
				}
				if (params.get("city") != null) {
					SET(" city = #{city} ");
				}
				if (params.get("county") != null) {
					SET(" county = #{county} ");
				}
				if (params.get("detailAddress") != null) {
					SET(" detail_address = #{detail_address} ");
				}
				if (params.get("name") != null) {
					SET(" name = #{name} ");
				}
				if (params.get("phoneNum") != null) {
					SET(" phone_num = #{phone_num} ");
				}
				if (params.get("zipCode") != null) {
					SET(" zip_code = #{zip_code} ");
				}
				if (params.get("userId") != null) {
					WHERE(" user_id = #{user_id} ");
				}
				if (params.get("addressId") != null) {
					WHERE(" address_id = #{address_id} ");
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
				INSERT_INTO("recipient_info");
				if (params.get("userName") != null) {
					VALUES("province", "#{province}");
				}
				if (params.get("city") != null) {
					VALUES("city", "#{city}");
				}
				if (params.get("county") != null) {
					VALUES("county", "#{county}");
				}
				if (params.get("detail_address") != null) {
					VALUES("detail_address", "#{detail_address}");
				}
				if (params.get("name") != null) {
					VALUES("name", "#{name}");
				}
				if (params.get("phone_num") != null) {
					VALUES("phone_num", "#{phone_num}");
				}
				if (params.get("zip_code") != null) {
					VALUES("zip_code", "#{zip_code}");
				}
			}
		}.toString();
	}

}
