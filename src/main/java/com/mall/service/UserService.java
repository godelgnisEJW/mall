package com.mall.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.dao.UserDao;
import com.mall.model.Message;
import com.mall.model.User;

/**
 * 对用户进行查询和创建，信息更改
 * 删除用户只有管理者有权限进行操作
 * @author godlegnis
 *
 */
@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	@Autowired
	StringEncryptor encryptor;
	
	/**
	 * 登录账户
	 * @param userName
	 * @return
	 */
	public User login(String userName, String password) {
		User user = userDao.selectByUserName(userName);
		if (user != null) {
			//将密码解密成明文
			String plaintext = encryptor.decrypt(user.getPassword());
			if (password.equals(plaintext) && !user.getUserType().equals("freezed")) {
				return user;
			}else {
				return new User();
			}
		}
		return new User();
	}
	/**
	 * 注册新用户
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean register(String userName, String password) {
		User user = userDao.selectByUserName(userName);
		if(user != null) {
			//用户名已被占用，返回false
			return false;
		}else {
			user = new User();
			user.setUserName(userName);
			//密码加密后的密文
			String ciphertext = encryptor.encrypt(password);
			user.setPassword(ciphertext);
			//设置为普通用户类型
			user.setUserType("normal");
			userDao.insertUser(user);
			return true;
		}
	}
	/**
	 * 退出登录状态
	 * @param user
	 * @param session
	 * @return
	 */
	public Message logout(User user, HttpSession session) {
		try {
			if (session.getAttribute("user") != null) {
				session.removeAttribute("user");
				return new Message("退出成功");
			}else {
				return new Message("请先登录");
			}
		} catch (Exception e) {
			return new Message("退出失败");
		}
	}
	/**
	 * 更改用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUserInfo(User user) {
		try {
			userDao.updateWithUser(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 添加用户，用户名必须是唯一的
	 * @param user
	 * @return
	 */
	public Message addUser(User user) {
		Message message = new Message();
		//先查看数据库中是否已经存在该用户名
		if (null != userDao.selectByUserName(user.getUserName())) {
			message.setMessage("添加失败，用户名已存在");
			return message;
		}
		try {
			userDao.insertUser(user);
		} catch (Exception e) {
			//添加过程出错
			message.setMessage("添加失败");
			return message;
		}
		//正常进行中
		message.setMessage("添加成功");
		message.getOptionParam().put("userId", user.getUserId());
		return message;
	}
	
	/**
	 * 查询所有的用户
	 * @return
	 */
	public ArrayList<User> selectAll(){
		return userDao.selectAll();
	}
	
	/**
	 * 根据用户名进行模糊查询
	 * @param userName
	 * @return
	 */
	public ArrayList<User> fuzzyQueryByName(String userName){
		return userDao.fuzzyQueryByName(userName);
	}
}
