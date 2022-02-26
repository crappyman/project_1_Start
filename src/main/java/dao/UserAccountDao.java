package dao;

import java.util.List;

import models.User;

public interface UserAccountDao {
	 String getUserRole(Integer roleId);
	    List<User> getListOfUserAccount();
	    User getUserAccountInfo(User user);
	    Boolean addNewUserAccount(User user);
	    Boolean editUserAccount(User user);
}
