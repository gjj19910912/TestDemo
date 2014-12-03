package com.bmtech.pushmessage.service;

import java.util.HashMap;
import java.util.List;

public interface UserService {
	/**
	 * ÅÐ¶ÏÊÇ·ñµÇÂ½³É¹¦
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean isRightLogin(String username,String password);
	
	public List<HashMap<String,Object>> getUserList(int starts,int sizes);
}
