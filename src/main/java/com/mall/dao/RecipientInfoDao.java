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

import com.mall.model.RecipientInfo;
import com.mall.model.User;

@Mapper
public interface RecipientInfoDao {
	
	/**
	 * 根据地址Id查询收件地址信息
	 * @param addressId  地址Id
	 * @return
	 */
	@Select("select * from recipient_info where address_id = #{addressId}")
	public RecipientInfo selectByAddressId(Integer addressId);

	/**
	 * 根据用户Id查询用户的所有收件地址
	 * @param userId 用户Id
	 * @return
	 */
	@Select("select * from recipient_info where user_id = #{userId}")
	public ArrayList<RecipientInfo> selectByUserId(Integer userId);
	
	/**
	 * 添加收件人信息
	 * @param recipientInfo 新的收件人信息
 	 * @return  新插入的收件人信息的地址Id address_id
	 */
	@Insert("insert into recipient_info(province, city, county, detail_address, name, phone_num, zip_code, user_id)"
			+ "values(#{province},#{city},#{county},#{detailAddress},#{name},#{phoneNum},#{zipCode},#{userId})")
	@Options(useGeneratedKeys = true, keyProperty = "addressId", keyColumn = "address_id")
	public int insertRecipientInfo(RecipientInfo recipientInfo);
	
	/**
	 * 删除收件人信息
	 * @param addressId 地址ID
	 */
	@Delete("delete from recipient_info where address_id = #{addressId}")
	public void deleteRecipientInfo(Integer addressId);
	
	/**
	 * 更新收件人信息
	 * @param recipientInfo 新的收件人信息
	 */
	@Update("update recipient_info set "
			+ "province = #{province},"
			+ "city = #{city},"
			+ "county = #{county},"
			+ "detail_address = #{detailAddress},"
			+ "name = #{name},"
			+ "phone_num = #{phoneNum},"
			+ "zip_code = #{zipCode},"
			+ "user_id = #{userId} "
			+ "where address_id = #{addressId}")
	public void updateRecipientInfo(RecipientInfo recipientInfo);
	
	
	/**
	 * 动态更新
	 * @param recipientInfo
	 * @return
	 */
	@UpdateProvider(method = "updateWithRecipientInfo", type = com.mall.dynamicSql.RecipientInfoDynaSqlProvider.class)
	public void updateWithRecipientInfo(RecipientInfo recipientInfo);
	
	/**
	 * 动态插入
	 * @param recipientInfo
	 * @return
	 */
	@InsertProvider(method = "insertWithRecipientInfo", type = com.mall.dynamicSql.RecipientInfoDynaSqlProvider.class)
	public int insertWithRecipientInfo(RecipientInfo recipientInfo);
}
