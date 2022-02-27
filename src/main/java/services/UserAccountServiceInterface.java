package services;

import java.util.List;

import models.User;

public interface UserAccountServiceInterface {

	String getUserRole(Integer roleId);

	List<User> getListOfUserAccount();

	User getUserAccountInfo(User user);

	User addNewUserAccount(User user);

	User editUserPassword(User user);

}
