package com.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mall.service.LogisticsService;

@RestController
@RequestMapping("/logistics")
public class LogisticsController {

	@Autowired
	LogisticsService logisticsService;
	/**
	 * 查询物流轨迹
	 ******************************************* 
	 * 想要完善这个功能                                             *
	 * 还需要到数据库中在order这张表中                   *
	 * 添加expCod(快递公司代号)来记录是哪一家快递*
	 * *****************************************
	 * @param expCode
	 * @param expNo
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String logisticsQuery(@RequestParam("expCode")String expCode, @RequestParam("expNo")String expNo) {
		return logisticsService.logisticsQuery(expCode, expNo);
	}
}
