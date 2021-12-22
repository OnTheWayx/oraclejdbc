package service;

import dao.UserDao;
import po.User;

public class UserService implements IUserService {
	private UserDao uDao;
	public UserService() {
		uDao = new UserDao();
	}
	@Override
	public User CheckUser(String uname, String password) {
		return uDao.selectByUser(uname, password);
	}

	public boolean AddUser(User user) {
		return uDao.AddByUser(user);
	}
	
	public boolean DeleteUser(String uname) {
		return uDao.DeleteByUser(uname);
	}
}
