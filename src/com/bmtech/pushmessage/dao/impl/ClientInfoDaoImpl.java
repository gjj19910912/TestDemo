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
//		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		boolean isSuccess = false;
//		try {
//			conn = DBUtil.OpenConn();
//			String sql = "insert into clientinfo values(client_seq.nextval,?,?) ";
//			pre = conn.prepareStatement(sql);// 实例化预编译语句
////		    pre.setInt(1, id);// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
//		    pre.setString(1, client.getClientId());
//		    pre.setString(2, client.getPackageName());
//		    int count = pre.executeUpdate();
//		    if(count > 0){
//		    	isSuccess = true;
//		    }
////			System.out.println("连接成功！");
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
//				System.out.println("数据库连接已关闭！");
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
//		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
//		 ResultSet result = null;// 创建一个结果集对象
//		 List<ClientInfo> clients = new ArrayList<ClientInfo>();
//		try {
//			conn = DBUtil.OpenConn();
//			String sql = "select * from clientinfo ";
//			pre = conn.prepareStatement(sql);// 实例化预编译语句
////		    pre.setInt(1, id);// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
//		    int count = pre.executeUpdate();
//		    result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
//	        while (result.next()){
//	        	ClientInfo client = new ClientInfo();
//	        	client.setId(result.getInt("id"));
//	        	client.setClientId(result.getString("clientid"));
//	        	client.setPackageName(result.getString("packagename"));
//	        	clients.add(client);
//	        }
////	            // 当结果集不为空时
////	            System.out.println("学号:" + result.getInt("id") + "姓名:"
////	                    + result.getString("name"));
//	        
////			System.out.println("连接成功！");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				DBUtil.closeConn(conn, pre, result);
//				System.out.println("数据库连接已关闭！");
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
//		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
//		 ResultSet result = null;// 创建一个结果集对象
//		 ClientInfo client = null;
//		try {
//			conn = DBUtil.OpenConn();
//			String sql = "select * from clientinfo where id = ?";
//			pre = conn.prepareStatement(sql);// 实例化预编译语句
//		    pre.setInt(1, id);// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
//		    int count = pre.executeUpdate();
//		    result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
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
//				System.out.println("数据库连接已关闭！");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return client;
		return null;
	
	}

}
