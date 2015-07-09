package com.readingbbs.bean;

import java.util.ArrayList;

/**
 * 封装帖子的类
 * 
 * @author LG
 */
public class Post {
	private String mId; // 帖子id
	private String mArea; // 帖子所属讨论区
	private String mUserId; // 发帖人id
	private String mTitle; // 标题
	private String mContent; // 内容
	private String mDate; // 日期
	private int mCommentNum; // 评论次数
	private ArrayList<Comment> mComments; // 评论列表

	public Post() {

	}

	public String getArea() {
		return mArea;
	}

	public void setArea(String mArea) {
		this.mArea = mArea;
	}

	public String getUserId() {
		return mUserId;
	}

	public void setUserId(String mUserId) {
		this.mUserId = mUserId;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String mTitle) {
		this.mTitle = mTitle;
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

	public String getId() {
		return mId;
	}

	public void setId(String mId) {
		this.mId = mId;
	}

	public ArrayList<Comment> getComments() {
		return mComments;
	}

	public void setComments(ArrayList<Comment> mComments) {
		this.mComments = mComments;
	}

	public int getCommentNum() {
		return mCommentNum;
	}

	public void setCommentNum(int mCommentNum) {
		this.mCommentNum = mCommentNum;
	}

}
