package com.bmtech.pushmessage.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmtech.pushmessage.dao.UserDao;
import com.bmtech.pushmessage.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserDao userDao;
	
	@Override
	public boolean isRightLogin(String username, String password) {
		return userDao.isRightLogin(username, password);
	}

	@Override
	public List<HashMap<String, Object>> getUserList(int starts, int sizes) {
		return userDao.getUserList(starts, sizes);
	}
}
