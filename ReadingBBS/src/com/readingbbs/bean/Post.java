package com.readingbbs.bean;

import java.util.ArrayList;

/**
 * ��װ���ӵ���
 * 
 * @author LG
 */
public class Post {
	private String mId; // ����id
	private String mArea; // ��������������
	private String mUserId; // ������id
	private String mTitle; // ����
	private String mContent; // ����
	private String mDate; // ����
	private int mCommentNum; // ���۴���
	private ArrayList<Comment> mComments; // �����б�

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
