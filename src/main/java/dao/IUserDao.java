package dao;

import po.User;

public interface IUserDao {
/*
 * 根据用户名 密码 查询用户信息
 */
	public User selectByUser(String uname, String password);
	public boolean AddByUser(User user);
	public boolean DeleteByUser(String uname);
}
