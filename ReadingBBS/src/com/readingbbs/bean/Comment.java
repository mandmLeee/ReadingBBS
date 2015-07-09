package com.readingbbs.bean;

/**
 * 封装评论的类
 * @author LG*/
public class Comment {
    private String mPostId; // 对应帖子id
	private String mUserId; // 评论者id
	private String mContent; // 评论内容
	private String mDate; // 评论日期
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
