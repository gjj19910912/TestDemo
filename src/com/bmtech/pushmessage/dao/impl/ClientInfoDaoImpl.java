package com.bmtech.pushmessage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bmtech.pushmessage.dao.ClientInfoDao;
import com.bmtech.pushmessage.model.ClientInfo;


public class ClientInfoDaoImpl implements ClientInfoDao {
	public boolean insertClient(ClientInfo client){
//		Connection conn = null;
//		PreparedStatement pre = null;// ����Ԥ����������һ�㶼�������������Statement
		boolean isSuccess = false;
//		try {
//			conn = DBUtil.OpenConn();
//			String sql = "insert into clientinfo values(client_seq.nextval,?,?) ";
//			pre = conn.prepareStatement(sql);// ʵ����Ԥ�������
////		    pre.setInt(1, id);// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
//		    pre.setString(1, client.getClientId());
//		    pre.setString(2, client.getPackageName());
//		    int count = pre.executeUpdate();
//		    if(count > 0){
//		    	isSuccess = true;
//		    }
////			System.out.println("���ӳɹ���");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				if(isSuccess){
//					conn.commit();
//				}else{
//					conn.rollback();
//				}
//				DBUtil.closeConn(conn, pre, null);
//				System.out.println("���ݿ������ѹرգ�");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return isSuccess;
	}

	public List<ClientInfo> findClients() {
		// TODO Auto-generated method stub
//		Connection conn = null;
//		PreparedStatement pre = null;// ����Ԥ����������һ�㶼�������������Statement
//		 ResultSet result = null;// ����һ�����������
//		 List<ClientInfo> clients = new ArrayList<ClientInfo>();
//		try {
//			conn = DBUtil.OpenConn();
//			String sql = "select * from clientinfo ";
//			pre = conn.prepareStatement(sql);// ʵ����Ԥ�������
////		    pre.setInt(1, id);// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
//		    int count = pre.executeUpdate();
//		    result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
//	        while (result.next()){
//	        	ClientInfo client = new ClientInfo();
//	        	client.setId(result.getInt("id"));
//	        	client.setClientId(result.getString("clientid"));
//	        	client.setPackageName(result.getString("packagename"));
//	        	clients.add(client);
//	        }
////	            // ���������Ϊ��ʱ
////	            System.out.println("ѧ��:" + result.getInt("id") + "����:"
////	                    + result.getString("name"));
//	        
////			System.out.println("���ӳɹ���");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				DBUtil.closeConn(conn, pre, result);
//				System.out.println("���ݿ������ѹرգ�");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return clients;
		return null;
	}

	public ClientInfo findClientById(int id) {
//		Connection conn = null;
//		PreparedStatement pre = null;// ����Ԥ����������һ�㶼�������������Statement
//		 ResultSet result = null;// ����һ�����������
//		 ClientInfo client = null;
//		try {
//			conn = DBUtil.OpenConn();
//			String sql = "select * from clientinfo where id = ?";
//			pre = conn.prepareStatement(sql);// ʵ����Ԥ�������
//		    pre.setInt(1, id);// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
//		    int count = pre.executeUpdate();
//		    result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
//	        while (result.next()){
//	        	client = new ClientInfo();
//	        	client.setId(result.getInt("id"));
//	        	client.setClientId(result.getString("clientid"));
//	        	client.setPackageName(result.getString("packagename"));
//	        }
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				DBUtil.closeConn(conn, pre, result);
//				System.out.println("���ݿ������ѹرգ�");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return client;
		return null;
	
	}

}
