package com.readingbbs.bean;

/**
 * ��װ���۵���
 * @author LG*/
public class Comment {
    private String mPostId; // ��Ӧ����id
	private String mUserId; // ������id
	private String mContent; // ��������
	private String mDate; // ��������
	public String getPostId() {
		return mPostId;
	}
	public void setPostId(String mPostId) {
		this.mPostId = mPostId;
	}
	public String getUserId() {
		return mUserId;
	}
	public void setUserId(String mUserId) {
		this.mUserId = mUserId;
	}
	public String getContent() {
		return mContent;
	}
	public void setContent(String mContent) {
		this.mContent = mContent;
	}
	public String getDate() {
		return mDate;
	}
	public void setDate(String mDate) {
		this.mDate = mDate;
	}
}
