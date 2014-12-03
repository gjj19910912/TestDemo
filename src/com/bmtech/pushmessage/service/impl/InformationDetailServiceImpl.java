package com.bmtech.pushmessage.service.impl;

import com.bmtech.pushmessage.dao.InformationDetailDao;
import com.bmtech.pushmessage.dao.impl.InformationDetailDaoImpl;
import com.bmtech.pushmessage.model.InformationDetailEntity;
import com.bmtech.pushmessage.service.InformationDetailService;

public class InformationDetailServiceImpl implements InformationDetailService {

	private InformationDetailDao dao = new InformationDetailDaoImpl();
	public int inserInformation(InformationDetailEntity information) {
		// TODO Auto-generated method stub
		return dao.inserInformation(information);
	}
	public boolean updateInfomationIsRecivied(int id) {
		// TODO Auto-generated method stub
		return dao.updateInfomationIsRecivied(id);
	}
	public boolean updateInfomationMessage(String message, int id) {
		// TODO Auto-generated method stub
		return dao.updateInfomationMessage(message, id);
	}

}
