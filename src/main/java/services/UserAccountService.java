package services;


import dao.UserAccountDao;
import dao.UserAccountDaoImpl;
import models.User;


import java.util.List;
public class UserAccountService {
	 private UserAccountDao userAccountDao;

	    public UserAccountService(){
	        this.userAccountDao = new UserAccountDaoImpl();
	    }

	    public String getUserRole(Integer roleId){
	         return this.userAccountDao.getUserRole(roleId);
	    }

	    public List<User> getListOfUserAccount(){
	        return this.userAccountDao.getListOfUserAccount();
	    }

	    public User getUserAccountInfo(User user){
	        User tempUser = this.userAccountDao.getUserAccountInfo(user);
	        if (tempUser == null) {
	            return null;
	        }
			return tempUser;

	      

	    }

	    public User addNewUserAccount(User user){
	        //check if user name exists in the system
	        String tempUser = userAccountDao.getUserAccountInfo(user).getUserName();
	        if (tempUser != null) {
	            return null;
	        } else {
	           
	            this.userAccountDao.addNewUserAccount(user);
	        }
	        return this.userAccountDao.getUserAccountInfo(user);
	    }


	    public User editUserPassword(User user) {
	        User tempUser = this.userAccountDao.getUserAccountInfo(user);
	        if (tempUser == null) {
	            return null;
	        }

	        else { 
	        return this.userAccountDao.getUserAccountInfo(user);
	    }


}
}