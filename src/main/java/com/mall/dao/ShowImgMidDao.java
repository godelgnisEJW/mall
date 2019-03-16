package com.mall.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mall.model.ShowImgMid;

@Mapper
public interface ShowImgMidDao {
	
	/**
	 * 根据商品Id查询相应的图片Id中间记录
	 * @param proId
	 * @return
	 */
	@Select("select * from show_img_mid where pro_id = #{proId}")
	public ArrayList<ShowImgMid> seletByProId(Integer proId);
	
	/**
	 * 插入一条新的记录
	 * @param showImgMid
	 * @return
	 */
	@Insert("insert into show_img_mid(img_id, pro_id) values(#{imgId}, #{proId})")
	public int insert(ShowImgMid showImgMid);
	
	/**
	 * 根据商品Id和图片Id删除对应的中间记录
	 * @param proId
	 */
	@Delete("delete from show_img_mid where pro_id = #{proId} and img_id = #{imgId}")
	public void delete(ShowImgMid showImgMid);
	
	/**
	 * 根据商品Id和图片Id更新对应的中间记录
	 * @param showImgMid
	 * @param newImgId
	 */
	@Update("update show_img_mid set img_id = #{newImgId} where pro_id = #{showImgMid.proId} and img_id = #{showImgMid.imgId}")
	public void update(ShowImgMid showImgMid, Integer newImgId);
}
