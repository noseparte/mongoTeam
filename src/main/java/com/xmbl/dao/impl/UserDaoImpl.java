package com.xmbl.dao.impl;

import org.springframework.stereotype.Repository;

import com.xmbl.dao.UserDao;
import com.xmbl.model.UserEntity;
import com.xmbl.mongo.dao.GeneralDaoImpl;

@Repository
public class UserDaoImpl extends GeneralDaoImpl<UserEntity> implements UserDao{

	@Override
	protected Class<UserEntity> getEntityClass() {
		return UserEntity.class;
	}

}
