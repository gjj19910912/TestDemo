package com.bmtech.pushmessage.service.impl;


import java.util.List;

import com.bmtech.pushmessage.dao.ClientInfoDao;
import com.bmtech.pushmessage.dao.impl.ClientInfoDaoImpl;
import com.bmtech.pushmessage.model.ClientInfo;
import com.bmtech.pushmessage.service.ClientInfoService;


public class ClientInfoServiceImpl implements ClientInfoService{
	ClientInfoDao dao = new ClientInfoDaoImpl();
	public boolean insertClient(ClientInfo client){
		return dao.insertClient(client);
	}
	public List<ClientInfo> findClients() {
		// TODO Auto-generated method stub
		return dao.findClients();
	}
	public ClientInfo findClientById(int id) {
		// TODO Auto-generated method stub
		return dao.findClientById(id);
	}

}
