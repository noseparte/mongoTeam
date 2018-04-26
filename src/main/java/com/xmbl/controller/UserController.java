package com.xmbl.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmbl.base.BaseController;
import com.xmbl.model.UserEntity;
import com.xmbl.service.UserService;
import com.xmbl.web.api.bean.Response;
import com.xmbl.web.api.bean.Route;

/**
 * Copyright © 2018 noseparte © BeiJing BoLuo Network Technology Co. Ltd.
 * @Author Noseparte
 * @Compile 2018年4月26日 -- 下午4:43:53
 * @Version 1.0
 * @Description		用户管理
 */
@Controller
@RequestMapping(value=Route.PATH+Route.User.PATH)
public class UserController extends BaseController{

	private final static Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 获取用户列表
	 * @return
	 */
	@RequestMapping(value=Route.User.USER_LIST,method=RequestMethod.POST)
	@ResponseBody
	public Response userList(@RequestParam(value = "pageNo") int pageNo,@RequestParam(value = "pageSize") int pageSize) {
		log.info("infoMsg:--- 获取用户列表开始");
		Response reponse = this.getReponse();
		try {
			Query query = new Query();
			// 分页
			query.skip((pageNo - 1) * pageSize).limit(pageSize);
			query.with(new Sort(new Order(Direction.DESC,"createTime")));
			List<UserEntity> userList = userService.find(query);
			log.info("infoMsg:--- 获取用户列表结束");
			return reponse.success(userList);
		} catch (Exception e) {
			log.error("errorMsg:{--- 获取用户列表失败" + e.getMessage() + "---}");
			return reponse.failure(e.getMessage()); 
		}
	}
	
	
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping(value=Route.User.ADD_USER,method=RequestMethod.POST)
	@ResponseBody
	public Response add_user(@RequestParam(value = "name") String name,@RequestParam(value = "code") String code,
			@RequestParam(value = "phone") String phone,@RequestParam(value = "sex") int sex,@RequestParam(value = "address") String address) {
		log.info("infoMsg:--- 添加用户开始");
		Response reponse = this.getReponse();
		try {
			UserEntity user = new UserEntity(name, code, phone, sex, address); 
			userService.insert(user);
			log.info("infoMsg:--- 添加用户结束");
			return reponse.success();
		} catch (Exception e) {
			log.error("errorMsg:{--- 添加用户失败" + e.getMessage() + "---}");
			return reponse.failure(e.getMessage()); 
		}
	}
	
	
	
	
	
	
	
	
}
