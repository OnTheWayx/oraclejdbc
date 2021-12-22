package service;

import po.User;

public interface IUserService {
	public User CheckUser(String uname, String password);
	public boolean AddUser(User user);
	public boolean DeleteUser(String uname);
}
