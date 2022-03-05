package dao;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import pojo.UserPojo;

public class UserDaoImp implements UserDao {
	@Override
	public List<UserPojo> fetchAllAccounts() {
		Connection conn = DBUtil.obtainConnection();
		List<UserPojo> userpojo= new ArrayList();
        String query = "SELECT user_id,username ,password ,full_name ,email,role_id  FROM users ;";
            PreparedStatement ps;
			try {
				ps = conn.prepareStatement(query);
				   ResultSet rs = ps.executeQuery();
			       while(rs.next()){
			    	   userpojo.add(
		                        new UserPojo(
		                            rs.getInt("user_id"),
		                            rs.getString("username"),
		                            rs.getString("password"),
		                            rs.getString("full_name"),
		                            rs.getString("email"),
		                            rs.getInt("role_id")
		                ));
			       }
			         ps.close();
			     } catch (Exception ex) {
			         ex.printStackTrace();
			     }
			     return userpojo;
				}
	@Override
	public UserPojo fetchAAccount(int userId) {
		UserPojo userInfo=null; 
		Connection conn = DBUtil.obtainConnection();
		try {
			 Statement stmt = conn.createStatement();
		  String sql = "SELECT * FROM users WHERE user_id ="+userId;
		 
			
	          ResultSet rs = stmt.executeQuery(sql);

	          while(rs.next()){
	              userInfo = new UserPojo(
		                          rs.getInt("user_id"),
		                            rs.getString("username"),
		                            rs.getString("password"),
		                            rs.getString("full_name"),
		                            rs.getString("email"),
		                            rs.getInt("role_id"));
	          }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
       
    
    return userInfo;
	}
	@Override
	public UserPojo updateAccount( UserPojo userpojo) {
		Connection conn = DBUtil.obtainConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "UPDATE users SET email="+userpojo.getEmail()+" WHERE user_id="+userpojo.getUserID();
			int rows = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		
		return userpojo;
	}

}
