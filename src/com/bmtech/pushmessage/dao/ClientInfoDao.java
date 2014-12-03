package com.bmtech.pushmessage.dao;

import java.util.List;

import com.bmtech.pushmessage.model.ClientInfo;

public interface ClientInfoDao {
	public boolean insertClient(ClientInfo client);
	public List<ClientInfo> findClients();
	public ClientInfo findClientById(int id);
}
