package com.mall.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.dao.RecipientInfoDao;
import com.mall.model.RecipientInfo;

@Service
public class RecipientInfoService {

	@Autowired
	RecipientInfoDao recipientInfoDao;
	
	public ArrayList<RecipientInfo> selectByUserId(int userId){
		return recipientInfoDao.selectByUserId(userId);
	}
	
	public void add(RecipientInfo recipientInfo) {
		recipientInfoDao.insertRecipientInfo(recipientInfo);
	}
	
	public void delete(int addressId) {
		recipientInfoDao.deleteRecipientInfo(addressId);
	}
	
	public void update(RecipientInfo recipientInfo) {
		recipientInfoDao.updateWithRecipientInfo(recipientInfo);
	}
	
}
