package com.readingbbs.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.readingbbs.bean.User;
import com.readingbbs.db.DBHelper;

/**
 * 用户信息数据库操作工具类
 * 
 * @author LG
 */
public class UserDBUtil {
	private User mUser;
	private Connection mConnection;

	public UserDBUtil() {
		if (mConnection == null)
			mConnection = DBHelper.getSqlConnection();
	}

	public UserDBUtil(User user) {
		mUser = user;
		if (mConnection == null)
			mConnection = DBHelper.getSqlConnection();
	}

	/**
	 * 判断该用户名是否被注册
	 * 
	 * @author LG
	 */
	public boolean isRegistered() {
		boolean isRegistered = false;
		try {
			Statement sm = mConnection.createStatement();
			String sql = "select * from users where id = '" + mUser.getId()
					+ "'";
			ResultSet rs = sm.executeQuery(sql);
			if (rs.next())
				isRegistered = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isRegistered;
	}

	/**
	 * 注册用户
	 * 
	 * @author LG
	 */
	public boolean registerUser() {
		boolean isSuccessed = false;
		try {
			Statement sm = mConnection.createStatement();
			String sql = "insert into users values('" + mUser.getId() + "','"
					+ mUser.getPwd() + "','normal','" + mUser.getName() + "','"
					+ mUser.getSex() + "','" + mUser.getBirthday() + "','"
					+ mUser.getEmail() + "')";
			System.out.println("插入语句" + sql);
			sm.execute(sql);
			isSuccessed = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isSuccessed;

	}

	/**
	 * 判断是是否通过登录认证
	 * 
	 * @author LG
	 */
	public boolean isPassedLogin() {
		boolean isSuccessed = false;
		try {
			Statement sm = mConnection.createStatement();
			String sql = "select * from users where id = '" + mUser.getId()
					+ "' and pwd = '" + mUser.getPwd() + "'";
			ResultSet rs = sm.executeQuery(sql);
			if (rs.next())
				isSuccessed = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isSuccessed;
	}

	/**
	 * 完善user对象信息
	 * 
	 * @author LG
	 */
	public void completeUser() {
		try {
			Statement sm = mConnection.createStatement();
			String sql = "select * from users where id = '" + mUser.getId()
					+ "'";
			ResultSet rs = sm.executeQuery(sql);
			rs.next();
			String name = rs.getString("name");
			String sex = rs.getString("sex");
			String birthday = rs.getString("birthday");
			String email = rs.getString("email");
			String authority = rs.getString("authority");
			mUser.setName(name);
			mUser.setSex(sex);
			mUser.setBirthday(birthday);
			mUser.setEmail(email);
			mUser.setAuthority(authority);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新用户密码的数据库操作
	 * 
	 * @author LG
	 */
	public void resetPwd() {
		try {
			Statement sm = mConnection.createStatement();
			String sql = "update users set pwd='" + mUser.getPwd() + "'"
					+ " where id='" + mUser.getId() + "'";
			sm.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取所有用户列表
	 * 
	 * @return ArrayList<User>
	 * @author LG
	 */
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		try {
			Statement sm = mConnection.createStatement();
			String sql = "select * from users";
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String authority = rs.getString("authority");
				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setAuthority(authority);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * 删除用户
	 * 
	 * @author LG
	 */
	public void deleteUser(String id) {
		try {
			Statement sm = mConnection.createStatement();
			String sql = "delete from users where id='" + id + "'";
			sm.execute(sql);
			sql = "delete from comments where user_id='" + id + "'";
			sm.execute(sql);
			sql = "delete from posts where user_id='" + id + "'";
			sm.execute(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
