package com.mall.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mall.model.Img;
@Mapper
public interface ImgDao {
	/**
	 * 根据img_id查询图片
	 * @param imgId
	 * @return
	 */
	@Select("select * from img where img_id = #{imgId}")
	public Img selectByImgId(Integer imgId);
	/**
	 * 根据商品Id查询商品展示图片
	 * @param proId
	 * @return
	 */
	@Select("select * from img natural join show_img_mid where pro_id = #{proId}")
	public ArrayList<Img> selectByProId(Integer proId);
	/**
	 * 根据上架号查询商品的详情图片
	 * @param upperId
	 * @return
	 */
	@Select("select * from img natural join detail_img_mid where upper_id = #{upperId}")
	public ArrayList<Img> selectByUpperId(Integer upperId);
	/**
	 * 根据图片Id删除图片记录
	 * @param imgId
	 */
	@Delete("delete from img where img_id = #{imgId}")
	public void deleteByImgId(Integer imgId);
	/**
	 * 更新图片路径
	 * @param imgId
	 */
	@Update("update img set url = #{url} where img_id = #{imgId}")
	public void updateImg(Img img);
	/**
	 * 插入一条图片记录
	 * @param img
	 * @return 插入图片的id
	 */
	@Insert("insert into img (url) values (#{url})")
    @Options(useGeneratedKeys = true, keyProperty = "imgId", keyColumn = "img_id")
	public int insertImg(Img img);
	
}
