package com.bmtech.pushmessage.dao;

import com.bmtech.pushmessage.model.InformationDetailEntity;

public interface InformationDetailDao {
	public int inserInformation(InformationDetailEntity information);
	public boolean updateInfomationIsRecivied(int id);
	public boolean updateInfomationMessage(String message,int id);
}
