package com.bmtech.pushmessage.model;

public class ClientInfo {
	private int id;
	private String clientId;
	private String packageName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public ClientInfo(int id, String clientId,String packageName) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.packageName = packageName;
	}
	public ClientInfo() {
		super();
	}
	

}
