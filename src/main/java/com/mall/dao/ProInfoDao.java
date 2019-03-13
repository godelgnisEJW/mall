package com.mall.dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.mall.bean.ProInfo;
@Mapper
public interface ProInfoDao {
	
	@Select("select * from pro_info where pro_id = #{pro_id}")
	@Results({
		@Result(column = "pro_id", property = "imges",
				many = @Many(
						select = "com.mall.dao.ImgDao.selectByProId"))
	})
	public ProInfo selectByProId(@Param("pro_id")Integer proId);
}
