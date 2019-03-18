package com.mall.service;

import org.springframework.stereotype.Service;

import com.mall.model.KDNTrackQueryAPI;

/**
 * 物流服务，有时间再写
 * @author godlegnis
 *
 */
@Service
public class LogisticsService {
	
	/**
	 * 通过使用快递鸟的即使查询接口来获取物流轨迹
	 * @param expCode
	 * @param expNo
	 * @return
	 */
	public String logisticsQuery(String expCode, String expNo) {
		KDNTrackQueryAPI api = new KDNTrackQueryAPI();
		try {
			String result = api.getOrderTracesByJson(expCode, expNo);
			return result.toString();
		} catch (Exception e) {
			return "服务器出错，请稍后重试!";
		}
	}
}
