package com.mall.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mall.dao.ImgDao;
import com.mall.model.Img;

@Service
public class ImgService {

	@Autowired
	ImgDao imgDao;
	
	
	/**
	 * 将图片添加到指定的路径并重命名
	 * @param file
	 * @return
	 */
	public Img addImg(MultipartFile file) {
		
		Img img = new Img();
		if (file.isEmpty()) {
            return img;
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        String filePath = "D:/temp/img/"; // 上传后的路径
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            return img;
        }
        String url = "/temp/img/" + fileName;
        img.setUrl(url);
        return img;
	}
	
	/**
	 * 在img表中插入一条记录
	 * @param img
	 * @return
	 */
	public int insertImg(Img img) {
		return imgDao.insertImg(img);
	}
	
	/**
	 * 删除图片和img表中的数据
	 * @param img
	 */
	public void deleteImg(Img img) {
		deleteFile(img.getUrl());
		imgDao.deleteByImgId(img.getImgId());
	}
	
	/**
	 * 删除图片并更新img表中的数据
	 * @param img
	 */
	public void updateImg(Img img) {
		deleteFile(img.getUrl());
		imgDao.updateImg(img);
	}
	
	/**
	 * 从磁盘上删除图片
	 * @param url
	 */
	public void deleteFile(String url) {
		url = "D:/" + url;
		File file = new File(url);
		if (file.exists()) {
			file.delete();
		}
	}
}
