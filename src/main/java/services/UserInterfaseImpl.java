package services;

import java.util.List;

import dao.UserDao;
import dao.UserDaoImp;
import pojo.UserPojo;

public class UserInterfaseImpl implements UserInterfase {
	
UserDao userdoa=new UserDaoImp();
	@Override
	public List<UserPojo> fetchAllAccounts() {
		return userdoa.fetchAllAccounts();
	}

	@Override
	public UserPojo fetchAAccount(int userId) {
		return userdoa.fetchAAccount(userId);
	}

	@Override
	public UserPojo updateAccount(UserPojo userpojo) {
		return userdoa.updateAccount(userpojo);
	}

}
