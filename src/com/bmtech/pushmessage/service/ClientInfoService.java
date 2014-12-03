package com.bmtech.pushmessage.service;

import java.util.List;

import com.bmtech.pushmessage.model.ClientInfo;

public interface ClientInfoService {
	public boolean insertClient(ClientInfo client);
	public List<ClientInfo> findClients();
	public ClientInfo findClientById(int id);
}
