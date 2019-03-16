package com.mall.dynamicSql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.mall.model.RecipientInfo;

public class RecipientInfoDynaSqlProvider {
	
	/**
	 * 动态更新
	 * @param params
	 * @return
	 */
	public String updateWithRecipientInfo(RecipientInfo recipientInfo) {
		return new SQL() {
			{
				UPDATE("recipient_info");
				if (recipientInfo.getProvince() != null) {
					SET(" province = #{province} ");
				}
				if (recipientInfo.getCity() != null) {
					SET(" city = #{city} ");
				}
				if (recipientInfo.getCounty() != null) {
					SET(" county = #{county} ");
				}
				if (recipientInfo.getDetailAddress() != null) {
					SET(" detail_address = #{detailAddress} ");
				}
				if (recipientInfo.getName() != null) {
					SET(" name = #{name} ");
				}
				if (recipientInfo.getPhoneNum() != null) {
					SET(" phone_num = #{phoneNum} ");
				}
				if (recipientInfo.getZipCode() != null) {
					SET(" zip_code = #{zipCode} ");
				}
				if (recipientInfo.getUserId() != null) {
					WHERE(" user_id = #{userId} ");
				}
				if (recipientInfo.getAddressId() != null) {
					WHERE(" address_id = #{addressId} ");
				}
			}
		}.toString();
	}
	
	/**
	 * 动态插入
	 * @param params
	 * @return
	 */
	public String insertWithRecipientInfo(RecipientInfo recipientInfo) {
		return new SQL() {
			{
				INSERT_INTO("recipient_info");
				if (recipientInfo.getProvince() != null) {
					VALUES("province", "#{province}");
				}
				if (recipientInfo.getCity() != null) {
					VALUES("city", "#{city}");
				}
				if (recipientInfo.getCounty() != null) {
					VALUES("county", "#{county}");
				}
				if (recipientInfo.getDetailAddress() != null) {
					VALUES("detail_address", "#{detailAddress}");
				}
				if (recipientInfo.getName() != null) {
					VALUES("name", "#{name}");
				}
				if (recipientInfo.getPhoneNum() != null) {
					VALUES("phone_num", "#{phoneNum}");
				}
				if (recipientInfo.getZipCode() != null) {
					VALUES("zip_code", "#{zipCode}");
				}
				if (recipientInfo.getUserId() != null) {
					VALUES("user_id", "#{userId}");
				}
			}
		}.toString();
	}

}
