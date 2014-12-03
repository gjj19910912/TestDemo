package com.bmtech.pushmessage.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONObject;

import com.bmtech.pushmessage.model.ClientInfo;
import com.bmtech.pushmessage.model.InformationDetailEntity;
import com.bmtech.pushmessage.service.ClientInfoService;
import com.bmtech.pushmessage.service.InformationDetailService;
import com.bmtech.pushmessage.service.impl.ClientInfoServiceImpl;
import com.bmtech.pushmessage.service.impl.InformationDetailServiceImpl;
import com.bmtech.pushmessage.utils.MQTTBrokerProxyServer;
import com.bmtech.pushmessage.utils.MqttBroker;
import com.ibm.mqtt.MqttException;
import com.opensymphony.xwork2.ActionSupport;


public class PushContorller extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String clientId;
	public List<ClientInfo> users;
	private String packageName;
	public MQTTBrokerProxyServer mqttBrokerServer = new MQTTBrokerProxyServer();
	ClientInfoService services = new ClientInfoServiceImpl();
	InformationDetailService infoService = new InformationDetailServiceImpl();
	private String responseStr;
	private ClientInfo clientInfo;
	private String ids;
	private int infoId;
	
	public String pushTets() throws IOException{
		mqttBrokerServer.startServer();
		MqttBroker mqttBroker = new MqttBroker();
		try {
			mqttBroker.connect();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			//连接问题
			e.printStackTrace();
		}catch(Exception e){
			//?客户机和broker已经断开
		}
		 JSONObject json = new JSONObject();
		 json.put("type", "phone");
	     json.put("pacage", "test");
	     mqttBroker.sendMessage("490fef268c9a7deb", json.toString());
	     mqttBrokerServer.stopServer();
//	     infoService.inserInformation()
		return SUCCESS;
	}
	
	//给单个或多个对象推送消息
	public String sendInformations(){
		
		String[] idss = ids.split(",");
		System.out.println(123);
		try {
			mqttBrokerServer.startServer();
		
		MqttBroker mqttBroker = new MqttBroker();
		try {
			mqttBroker.connect();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			//连接问题
			e.printStackTrace();
		}catch(Exception e){
			//?客户机和broker已经断开
		}
		JSONObject json = new JSONObject();
		 json.put("type", "phone");
	     json.put("pacage", "test");
	     JSONObject jsonCopy = json;
	     InformationDetailEntity info = null;
		for(int i = 0; i < idss.length; i ++){
			ClientInfo ci = services.findClientById(Integer.valueOf(idss[i]));
			if(ci != null){
				 info = new InformationDetailEntity();
				 info.setMessage(json.toString());
				 info.setReceivedClientId(ci.getClientId());
				 info.setPackageName(ci.getPackageName());
				 int id = infoService.inserInformation(info);
				 jsonCopy.put("infoId", id);
				 mqttBroker.sendMessage(ci.getClientId(), jsonCopy.toString());
				 infoService.updateInfomationMessage(jsonCopy.toString(), id);
			}
		}
	     mqttBrokerServer.stopServer();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	//客户端提交客户端id，应用包名，数据库保存
	public String sendClientId(){
		services.insertClient(clientInfo);
		return SUCCESS;
	}
	
	public String clientReceived(){
		infoService.updateInfomationIsRecivied(infoId);
		return SUCCESS;
	}
	
	public String gridData(){
		users = services.findClients();
		return SUCCESS;
	}
	
//	@JSON(serialize=false)
	public String getClientId() {
		return clientId; 
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public List<ClientInfo> getUsers() {
		return users;
	}
	public void setUsers(List<ClientInfo> users) {
		this.users = users;
	}
	
//	@JSON(serialize=false)
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	
	public String getResponseStr() {
		return responseStr;
	}
	public void setResponseStr(String responseStr) {
		this.responseStr = responseStr;
	}
	public ClientInfo getClientInfo() {
		return clientInfo;
	}
	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	

}
