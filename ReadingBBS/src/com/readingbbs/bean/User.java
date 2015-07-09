package com.readingbbs.bean;

/**
 * 封装用户信息的类
 * 
 * @author LG
 */
public class User {
	private String mId; // 用户名
	private String mPwd; // 密码
	private String mAuthority; // 权限
	private String mName; // 名字
	private String mSex; // 性别
	private String mBirthday; // 出生日期
	private String mEmail; // 邮箱

	public String getId() {
		return mId;
	}

	public void setId(String mId) {
		this.mId = mId;
	}

	public String getPwd() {
		return mPwd;
	}

	public void setPwd(String mPwd) {
		this.mPwd = mPwd;
	}

	public String getAuthority() {
		return mAuthority;
	}

	public void setAuthority(String mAuthority) {
		this.mAuthority = mAuthority;
	}

	public String getName() {
		return mName;
	}

	public void setName(String mName) {
		this.mName = mName;
	}

	public String getSex() {
		return mSex;
	}

	public void setSex(String mSex) {
		this.mSex = mSex;
	}

	public String getBirthday() {
		return mBirthday;
	}

	public void setBirthday(String mBirthday) {
		this.mBirthday = mBirthday;
	}

	public String getEmail() {
		return mEmail;
	}

	public void setEmail(String mEmail) {
		this.mEmail = mEmail;
	}

}
