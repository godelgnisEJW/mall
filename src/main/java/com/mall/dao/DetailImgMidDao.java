package com.mall.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mall.model.DetailImgMid;

@Mapper
public interface DetailImgMidDao {
	/**
	 * 根据上架号对应的详情图片Id中间记录
	 * @param upperId
	 * @return
	 */
	@Select("select * from detail_img_mid where upper_id = #{upper_id}")
	public ArrayList<DetailImgMid> selectByUpperId(@Param("upper_id")Integer upperId);

	/**
	 * 向表中插入一条新纪录
	 * @param detailImgMid
	 * @return
	 */
	@Insert("insert into detail_img_mid(img_id, upper_id) values(#{img_id}, #{upper_id})")
	public int insert(DetailImgMid detailImgMid);
	
	/**
	 * 根据上架号和图片Id来更新商品对应的中间记录
	 * @param detailImgMid
	 * @param newImgId
	 */
	@Update("update detail_img_mid set img_id = #{new_img_id} where upper_id = #{upper_id} and img_id = #{img_id}")
	public void update(DetailImgMid detailImgMid, @Param("new_img_id")Integer newImgId);
	
	/**
	 * 根据上架号和图片Id删除对应的中间记录
	 * @param upperId
	 */
	@Delete("delete from detail_img_mid where upper_id = #{upper_id} and img_id = #{img_id}")
	public void delete(DetailImgMid detailImgMid);
}
