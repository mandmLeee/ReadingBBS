package com.readingbbs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ݿ�����࣬���Connection����
 * 
 * @author LG
 */
public class DBHelper {

	private static Connection mConnection;
	private static String mDriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String mUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=ReadingBBS";
	private static String mUserId = "sa";
	private static String mPassWord = "ligangde10";

	public static Connection getSqlConnection() {

		if (mConnection != null) {
			return mConnection;
		}
		// ���ӵ����ݿ�
		try {
			Class.forName(mDriverName);
			mConnection = DriverManager.getConnection(mUrl, mUserId, mPassWord);
			System.out.println("Connection Successful!"); // ���ӳɹ�
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return mConnection;

	}
}
