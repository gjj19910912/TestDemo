package com.bmtech.pushmessage.dao;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
	
	public boolean isRightLogin(String username,String password);
	
	public List<HashMap<String,Object>> getUserList(int starts,int sizes);

}
