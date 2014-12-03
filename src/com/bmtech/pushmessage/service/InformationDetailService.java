package com.bmtech.pushmessage.service;

import com.bmtech.pushmessage.model.InformationDetailEntity;


public interface InformationDetailService {
	public int inserInformation(InformationDetailEntity information);
	public boolean updateInfomationIsRecivied(int id);
	public boolean updateInfomationMessage(String message,int id);
}
