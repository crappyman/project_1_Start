package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.User;

public class UserAccountDaoImpl implements UserAccountDao {

	@Override
	public String getUserRole(Integer roleId) {
		Connection conn = DBUtil.obtainConnection();
		 String userRole = "";
	       
	            String query = "SELECT * FROM role WHERE roleid = ?;";
	            PreparedStatement ps;
				try {
					ps = conn.prepareStatement(query);
					ps.setInt(1, roleId);
					 ResultSet rs = ps.executeQuery();
					 while(rs.next()){
			                userRole =  rs.getString("role");
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	          return userRole;
	}

	@Override
	public List<User> getListOfUserAccount() {
		Connection conn = DBUtil.obtainConnection();
		List<User> userAccounts= new ArrayList<>();
        String query = "SELECT userid,username,firstname,lastname,email,roleid FROM user_details;";
            PreparedStatement ps;
			try {
				ps = conn.prepareStatement(query);
				   ResultSet rs = ps.executeQuery();
			       while(rs.next()){
		                userAccounts.add(
		                        new User(
		                            rs.getInt("userid"),
		                            rs.getString("username"),
		                            rs.getString("password"),
		                            rs.getString("firstname"),
		                            rs.getString("lastname"),
		                            rs.getString("email"),
		                            rs.getInt("roleid")
		                ));
		            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

         

     
        return userAccounts;
	}

	@Override
	public User getUserAccountInfo(User user) {
		Connection conn = DBUtil.obtainConnection();
		  User userInfo = new User();
		  String sql = "SELECT * FROM user_details WHERE username = ?;";
          PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			 ps.setString(1, user.getUserName());
	          ResultSet rs = ps.executeQuery();

	          while(rs.next()){
	              userInfo = new User(
	                      rs.getInt("userid"),
	                      rs.getString("username"),
	                      rs.getString("password"),
	                      rs.getString("firstname"),
	                      rs.getString("lastname"),
	                      rs.getString("email"),
	                      rs.getInt("roleid"));
	          }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
         
      
      return userInfo;
}

	@Override
	public Boolean addNewUserAccount(User user) {
		Connection conn = DBUtil.obtainConnection();
        String sql = "INSERT INTO user_details VALUES (DEFAULT, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps;
        try {
        ps = conn.prepareStatement(sql);

        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getFirstName());
        ps.setString(4, user.getLastName());
        ps.setString(5, user.getEmail());
        ps.setInt(6, user.getRoleId());
        return ps.executeUpdate() != 0;
        
    }catch(Exception ex){
        ex.printStackTrace();
        return  false;
    }
	}
		
	

	@Override
	public Boolean editUserAccount(User user) {
		Connection conn = DBUtil.obtainConnection();
		
        String sql = "UPDATE user_details SET password = ? WHERE username = ? ;";
        PreparedStatement ps;
        try {
        ps = conn.prepareStatement(sql);

        ps.setString(1, user.getPassword());
        ps.setString(2, user.getUserName());
        return ps.executeUpdate() != 0;

    }catch(Exception ex){
        ex.printStackTrace();
        return  false;
    }
	}

}
