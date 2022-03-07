package services;

import java.util.List;


import pojo.UserPojo;

public interface UserInterfase {

List<UserPojo> fetchAllAccounts();
	
	UserPojo fetchAAccount(int userId);
	
	UserPojo updateAccount (UserPojo userpojo);
	
	UserPojo login(UserPojo user);
}
