package com.bmtech.pushmessage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bmtech.pushmessage.dao.InformationDetailDao;
import com.bmtech.pushmessage.model.InformationDetailEntity;

public class InformationDetailDaoImpl implements InformationDetailDao {

	public int inserInformation(InformationDetailEntity information) {
		// TODO Auto-generated method stub

//		Connection conn = null;
//		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
////		boolean isSuccess = false;
//		ResultSet rs = null;
//		int id = 0;
//		try {
//			conn = DBUtil.OpenConn();
//			String sql = "insert into tb_information_detail values(information_seq.nextval,?,?,?,?,0) ";
//			 String sql2="select information_seq.currval  from dual"; 
//			pre = conn.prepareStatement(sql);// 实例化预编译语句
////		    pre.setInt(1, id);// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
//		    pre.setString(1, information.getMessage());
//		    pre.setString(2, information.getReceivedClientId());
//		    pre.setString(3, information.getPackageName());
//		    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//		    pre.setString(4, sdf.format(new Date()));
//		    int count = pre.executeUpdate();
//		    if(count > 0){
//		    	pre = conn.prepareStatement(sql2);
//	            rs =pre.executeQuery();
//	            if(rs.next()){
//	                id=rs.getInt(1);         
//	            }
//		    }
////			System.out.println("连接成功！");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				conn.commit();
//				DBUtil.closeConn(conn, pre, rs);
//				System.out.println("数据库连接已关闭！");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return id;
		return 1;
	}

	public boolean updateInfomationIsRecivied(int id) {
//		// TODO Auto-generated method stub
//
//		Connection conn = null;
//		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
//		boolean isSuccess = false;
//		try {
//			conn = DBUtil.OpenConn();
//			String sql = "update tb_information_detail set ISRECIVED = 1 where id = ?";
//			pre = conn.prepareStatement(sql);// 实例化预编译语句
//		    pre.setInt(1, id);
//		    int count = pre.executeUpdate();
//		    if(count > 0){
//		    	isSuccess = true;
//		    }
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
//		return isSuccess;
		return true;
	
	}

	public boolean updateInfomationMessage(String message,int id) {
		// TODO Auto-generated method stub

//		Connection conn = null;
//		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
//		boolean isSuccess = false;
//		try {
//			conn = DBUtil.OpenConn();
//			String sql = "update tb_information_detail set message = ? where id = ?";
//			pre = conn.prepareStatement(sql);// 实例化预编译语句
//		    pre.setString(1, message);
//		    pre.setInt(2, id);
//		    int count = pre.executeUpdate();
//		    if(count > 0){
//		    	isSuccess = true;
//		    }
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
//		return isSuccess;
		return true;
	
	}

}
