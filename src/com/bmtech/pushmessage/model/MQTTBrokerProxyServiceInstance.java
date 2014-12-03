package com.bmtech.pushmessage.model;

import com.bmtech.pushmessage.utils.MQTTBrokerProxyServer;

public class MQTTBrokerProxyServiceInstance {

	public static MQTTBrokerProxyServer mqtt = null;
	
	private MQTTBrokerProxyServiceInstance(){
		
	}
	
	public static MQTTBrokerProxyServer getInstance(){
		if(mqtt == null){
			return new MQTTBrokerProxyServer();
		}
		return mqtt;
	}
	
	
	
	
}
