package com.bmtech.pushmessage.model;

public class InformationDetailEntity {
	private int id;
	private String message;
	private String receivedClientId;
	private String packageName;
	private String time;
	private int isRceived;//0:未收到，1：已收到
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReceivedClientId() {
		return receivedClientId;
	}
	public void setReceivedClientId(String receivedClientId) {
		this.receivedClientId = receivedClientId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getIsRceived() {
		return isRceived;
	}
	public void setIsRceived(int isRceived) {
		this.isRceived = isRceived;
	}
	
}
