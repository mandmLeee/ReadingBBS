package com.readingbbs.bean;

/**
 * ��װ�û���Ϣ����
 * 
 * @author LG
 */
public class User {
	private String mId; // �û���
	private String mPwd; // ����
	private String mAuthority; // Ȩ��
	private String mName; // ����
	private String mSex; // �Ա�
	private String mBirthday; // ��������
	private String mEmail; // ����

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
