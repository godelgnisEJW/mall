package com.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mall.model.Img;
import com.mall.service.ImgService;

@RestController
@RequestMapping("/img")
public class ImgUploadController {

	@Autowired
	ImgService imgService;
	
	@PostMapping(value = "/upload")
	public Img imgUpload(@RequestParam(value = "file") MultipartFile file) {
		Img img = imgService.addImg(file);
		imgService.insertImg(img);
		return img;
	}
	
	
}
