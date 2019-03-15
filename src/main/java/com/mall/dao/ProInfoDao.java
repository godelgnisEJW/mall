package com.mall.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.mall.model.ProInfo;
import com.mall.model.User;
@Mapper
public interface ProInfoDao {
	/**
	 * 通过商品Id查询商品信息
	 * @param proId
	 * @return
	 */
	@Select("select * from pro_info where pro_id = #{pro_id}")
	@Results({
		@Result(column = "pro_id", property = "proId"),
		@Result(column = "pro_id", property = "imges",
				many = @Many(
						select = "com.mall.dao.ImgDao.selectByProId"))
	})
	public ProInfo selectByProId(@Param("pro_id")Integer proId);
	
	
	/**
	 * 通过上架号查询对应的多个商品型号的具体信息
	 * @param upperId
	 * @return
	 */
	@Select("select * from pro_info where upper_id = #{upper_id}")
	@Results({
		@Result(column = "pro_id", property = "proId"),
		@Result(column = "pro_id", property = "imges",
				many = @Many(
						select = "com.mall.dao.ImgDao.selectByProId"))
	})
	public ArrayList<ProInfo> selectByUpperId(@Param("upper_id")Integer upperId);
	
	/**
	 * 插入一条商品信息记录
	 * @param proInfo
	 * @return	主键pro_id
	 */
	@Insert("insert into pro_info(upper_id, pro_name, pro_type, price, stock, params) vaules(#upperId}, #proName}, #{proType}, #{price}, #{stock}, #{params})")
    @Options(useGeneratedKeys = true, keyProperty = "proId", keyColumn = "pro_id")
	public int insertProInfo(ProInfo proInfo);
	
	/**
	 * 通过商品Id删除记录
	 * @param proId
	 */
	@Delete("delete from pro_info where pro_id = #{pro_id}")
	public void deleteByProId(@Param("pro_id")Integer proId);
	
	/**
	 * 完全更新商品信息，只有params可以是空的，其他属性必须赋值，否则会出错
	 * @param proInfo
	 */
	@Update("update pro_info set "
			+ "upper_id = {#upperId}, "
			+ "pro_name = #proName}, "
			+ "pro_type = #{proType}, "
			+ "price = #{price}, "
			+ "stock = #{stock}, "
			+ "params = #{params}"
			+ "where pro_id = #{proId}")
	public void updateProInfo(ProInfo proInfo);
	
	/**
	 * 动态查询
	 * @param params
	 * @return
	 */
	@SelectProvider(method = "selectWithParams", type = com.mall.dynamicSql.ProInfoDynaSqlProvider.class)
	public User selectWithParams(Map<String, Object> params);
	
	/**
	 * 动态更新
	 * @param params
	 * @return
	 */
	@UpdateProvider(method = "updateWithParams", type = com.mall.dynamicSql.ProInfoDynaSqlProvider.class)
	public User updateWithParams(Map<String, Object> params);
	
	/**
	 * 动态插入
	 * @param params
	 * @return
	 */
	@InsertProvider(method = "insertWithParams", type = com.mall.dynamicSql.ProInfoDynaSqlProvider.class)
	public User insertWithParams(Map<String, Object> params);
	
}
