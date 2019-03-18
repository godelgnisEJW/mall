package com.mall.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.mall.model.Message;
import com.mall.model.User;
import com.mall.service.UserService;

/**
 * 用户登录只完成用户名登录注册
 * 手机号码登录则住
 * @author godlegnis
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	/**
	 * 用户登录
	 * 需要传入json数据形式的用户名和密码
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestBody User user, HttpServletResponse response, HttpSession session) {
		
		user = userService.login(user.getUserName(), user.getPassword());
		//如果取不到用户Id，说明数据库中没有不存在该用户
		if(null != user.getUserId()) {
			//将用户user存入seeesion中，以供其他的功能调用和拦截器过滤使用
			session.setAttribute("user", user);
			return user;
		}
		return user;
	}
	/**
	 * 用户注册，只限用户名注册,传入json格式用户名和密码
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public Message register(@RequestBody User user) {
		if(userService.register(user.getUserName(), user.getPassword())) {
			return new Message("注册成功");
		}else {
			return new Message("该用户名已被注册");
		}
	}
	
	/**
	 * 退出登录状态
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
	public Message logout(@RequestBody User user, HttpSession session) {
		return userService.logout(user, session);
	}
	/**
	 * 修改用户信息，信息中必须带上用户Id
	 * @param user 可以是部分用户信息，也可以是全部的用户信息
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Message updateUserInfo(@RequestBody User user) {
		if (userService.updateUserInfo(user)) {
			return new Message("修改成功");
		}else {
			return new Message("修改失败");
		}
	}
	
	//以下是admin用户才有的功能权限
	//修改用户类型为"freezed"可以限制用户登录
	/**
	 * 管理员添加用户功能
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Message addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	/**
	 * 查看所有的用户
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ArrayList<User> selectAll(@RequestParam(value = "pageNum" ,required = false)Integer pageNum, 
									 @RequestParam(value = "pageSize" ,required = false)Integer pageSize){
		if (pageNum != null && pageSize != null) {
			PageHelper.startPage(pageNum, pageSize);
		}
		return userService.selectAll();
	}
	
	/**
	 * 通过用户名模糊查询
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public ArrayList<User> fuzzyQueryByName(@RequestParam("userName")String userName,
											@RequestParam(value = "pageNum" ,required = false)Integer pageNum, 
											@RequestParam(value = "pageSize" ,required = false)Integer pageSize){
		if (pageNum != null && pageSize != null) {
			PageHelper.startPage(pageNum, pageSize);
		}
		return userService.fuzzyQueryByName(userName);
	}
	
}
