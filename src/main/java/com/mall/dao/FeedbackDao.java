package com.mall.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mall.model.Feedback;


@Mapper
public interface FeedbackDao {
	
	/**
	 * 通过fb_id查询反馈记录
	 * @param fbId
	 * @return
	 */
	@Select("select * from feedback where fb_id = #{fbId}")
	@Results({
		@Result(column = "img_id", property = "imgId"),
		@Result(column = "img_id", property = "img",
				one = @One(select = "com.mall.dao.ImgDao.selectByImgId"))
	})
	public Feedback selectByFbId(Integer fbId);
	
	/**
	 * 通过用户Id查询该用户的反馈记录
	 * @param userId
	 * @return
	 */
	@Select("select * from feedback where user_id = #{userId}")
	@Results({
		@Result(column = "img_id", property = "imgId"),
		@Result(column = "img_id", property = "img",
				one = @One(select = "com.mall.dao.ImgDao.selectByImgId"))
	})
	public ArrayList<Feedback> selectAllByUserId(Integer userId);
	
	/**
	 * 查询所有的反馈记录
	 * @return
	 */
	@Select("select * from feedback")
	@Results({
		@Result(column = "img_id", property = "imgId"),
		@Result(column = "img_id", property = "img",
				one = @One(select = "com.mall.dao.ImgDao.selectByImgId"))
	})
	public ArrayList<Feedback> selectAll();
	/**
	 * 添加一条反馈记录
	 * @param feedback
	 * @return
	 */
	@Insert("insert into feedback(user_id, fb_content, fb_time, img_id) values(#{userId}, #{fbContent}, #{fbTime}, #{imgId})")
    @Options(useGeneratedKeys = true, keyProperty = "fbId", keyColumn = "fb_id")
	public int insertFeedback(Feedback feedback);
	
	/**
	 *删除一条反馈记录
	 * @param fbId
	 */
	@Delete("delete from feedback where fb_id = #{fbId}")
	public void deleteFeedback(Integer fbId);
}
