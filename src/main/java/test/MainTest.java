package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import po.User;
import util.DBUtil;

public class MainTest {

	public static List<User> selectAll() {
		List<User> list = new ArrayList<User>();
		Connection conn = null;// 数据库连接时使用
		Statement stmt = null;// 数据库连接成功后，对数据进行操作时的对象
		ResultSet rst = null;// 查询数据时会返回结果集
		DBUtil db = new DBUtil();// 实例化一个对象
		try {
			conn = db.getConnection();// 连接数据库
			System.out.println("连接数据库成功！");
			// 试一试，查询emp中的数据
			String sql = "select * from users";
			// 操作数据 -- 查询
			stmt = conn.createStatement();// 创建数据操作对象
			rst = stmt.executeQuery(sql);// stmt执行查询语句,并把返回的结果放到了rst中
			ResultSetMetaData mData = rst.getMetaData(); // 获得结果集结构信息,元数据
			int count = mData.getColumnCount();
			// 遍历结果集、
			// System.out.println("----------商品列表----------");
			while (rst.next()) {
				User user = new User(rst.getString("NAME"), rst.getString("TEL"), rst.getInt("AGE"),
						rst.getString("email"), rst.getString("ADDRESS"), rst.getString("YESORNO"),
						rst.getString("PASSWORD"), rst.getDate("BIRTH"));
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println("连接数据库不成功");
			e.printStackTrace();
		} finally {
			// 释放所有资源
			db.closeAll(rst, stmt, conn);
		}
		return list;
	}

	public static void main(String[] args) {
		MainTest mainTest = new MainTest();
		List<User> list = mainTest.selectAll();
		for (User strMap : list)
			System.out.println(strMap);

	}

}