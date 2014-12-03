package com.bmtech.pushmessage.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmtech.pushmessage.dao.UserDao;

@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Autowired
	@Qualifier("sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public boolean isRightLogin(String username, String password) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("username", username);
		map.put("password", password);
		return getSqlSession().selectOne("User.isRightLogin", map) == null? false : true;
	}

	@Override
	public List<HashMap<String, Object>> getUserList(int starts, int sizes) {
		return getSqlSession().selectList("User.getAllUsers");
	}

}
