package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.User;
import util.DBUtil;

public class UserDao implements IUserDao {
	User user = null;
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public User selectByUser(String uname, String password) {
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from users where name='" + uname + "' and password='" + password + "'";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setUname(uname);
				user.setPassword(password);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(resultSet, preparedStatement, connection);
		}
		return user;
	}

	public boolean AddByUser(User user) {
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into users values(?,?,?,?,?,?,?,?)";
			Date sqlDate = new Date(user.getBirth().getTime());
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUname());
			preparedStatement.setString(2, user.getTel());
			preparedStatement.setInt(3, user.getAge());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.setString(6, user.getYesorno());
			preparedStatement.setString(7, user.getPassword());
			preparedStatement.setDate(8, sqlDate);
			if (preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(resultSet, preparedStatement, connection);
		}
		return false;
	}

	public boolean DeleteByUser(String uname) {
		try {
			connection = DBUtil.getConnection();
			String sql = "delete from users where name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, uname);
			if (preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(resultSet, preparedStatement, connection);
		}
		return false;
	}

}
