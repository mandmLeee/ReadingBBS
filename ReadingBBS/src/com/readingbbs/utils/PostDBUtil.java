package com.readingbbs.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.readingbbs.bean.Comment;
import com.readingbbs.bean.Post;
import com.readingbbs.bean.User;
import com.readingbbs.db.DBHelper;

/**
 * ������Ϣ���ݿ����������
 * 
 * @author LG
 */
public class PostDBUtil {

	private String mArea;
	private Connection mConnection;

	public PostDBUtil() {
		if (mConnection == null)
			mConnection = DBHelper.getSqlConnection();
	}

	public PostDBUtil(String area) {
		mArea = area;
		if (mConnection == null)
			mConnection = DBHelper.getSqlConnection();
	}

	/**
	 * ��ȡ������Ϣ
	 * 
	 * @return Post
	 * @author LG
	 */
	public Post getPost(String postId) {
		Post post = new Post();
		try {
			Statement sm = mConnection.createStatement();
			String sql = "select * from posts where id = '" + postId + "'";
			ResultSet rs = sm.executeQuery(sql);
			rs.next();
			String userId = rs.getString("user_id");
			String area = rs.getString("area");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String date = rs.getString("date");
			int commentNum = getCommentNum(postId);
			// ��ȡ�����б�
			ArrayList<Comment> comments = getComments(postId);
			post.setId(postId);
			post.setComments(comments);
			post.setUserId(userId);
			post.setArea(area);
			post.setTitle(title);
			post.setContent(content);
			post.setDate(date);
			post.setCommentNum(commentNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}

	/**
	 * ��ȡ�����б�
	 * 
	 * @return ArrayList<Post>
	 * @author LG
	 */
	public ArrayList<Post> getPosts() {
		ArrayList<Post> posts = new ArrayList<Post>();
		try {
			Statement sm = mConnection.createStatement();
			String sql = "select * from posts where area = '" + mArea + "'";
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				Post post = new Post();
				String id = rs.getString("id");
				String userId = rs.getString("user_id");
				String title = rs.getString("title");
				String date = rs.getString("date");
				// ��ȡ�����б�
				int commentNum = getCommentNum(id);
				post.setCommentNum(commentNum);
				post.setId(id);
				post.setUserId(userId);
				post.setTitle(title);
				post.setDate(date);
				posts.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return posts;
	}

	/**
	 * ��ȡ�����б�
	 * 
	 * @return ArrayList<Comment>
	 * @author LG
	 */
	private ArrayList<Comment> getComments(String postId) {
		ArrayList<Comment> comments = new ArrayList<Comment>();
		try {
			Statement sm = mConnection.createStatement();
			String sql = "select * from comments where post_id = '" + postId
					+ "'";
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				Comment comment = new Comment();
				String userId = rs.getString("user_id");
				String content = rs.getString("content");
				String date = rs.getString("date");
				comment.setUserId(userId);
				comment.setContent(content);
				comment.setDate(date);
				comments.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return comments;
	}

	/**
	 * ��ȡ�������۴���
	 * 
	 * @return int
	 * @author LG
	 */
	public int getCommentNum(String postId) {
		int commentNum = 0;
		try {
			Statement sm = mConnection.createStatement();
			String sql = "select * from comments where post_id = '" + postId
					+ "'";
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				commentNum++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentNum;

	}

	/**
	 * ����������Ϣ�����ݿ�
	 * 
	 * @author LG
	 */
	public void insertPost(Post post) {
		try {
			Statement sm = mConnection.createStatement();
			String sql = "insert into posts values ('" + post.getId() + "','"
					+ post.getArea() + "','" + post.getUserId() + "','"
					+ post.getTitle() + "','" + post.getContent() + "','"
					+ post.getDate() + "')";
			sm.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ����������Ϣ�����ݿ�
	 * 
	 * @author LG
	 */
	public void insertComment(Comment comment) {
		try {
			Statement sm = mConnection.createStatement();
			String sql = "insert into comments values ('" + comment.getPostId()
					+ "','" + comment.getUserId() + "','"
					+ comment.getContent() + "','" + comment.getDate() + "')";
			sm.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ��ȡ���������б�
	 * 
	 * @return ArrayList<Comment>
	 * @author LG
	 */
	public ArrayList<Comment> getAllComments() {
		ArrayList<Comment> comments = new ArrayList<Comment>();
		try {
			Statement sm = mConnection.createStatement();
			String sql = "select * from comments";
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				String userId = rs.getString("user_id");
				String date = rs.getString("date");
				String content = rs.getString("content");
				Comment comment = new Comment();
				comment.setUserId(userId);
				comment.setDate(date);
				comment.setContent(content);
				comments.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comments;
	}

	/**
	 * ��ȡ���������б�
	 * 
	 * @return ArrayList<Post>
	 * @author LG
	 */
	public ArrayList<Post> getAllPosts() {
		ArrayList<Post> posts = new ArrayList<Post>();
		try {
			Statement sm = mConnection.createStatement();
			String sql = "select * from posts";
			ResultSet rs = sm.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("id");
				String userId = rs.getString("user_id");
				String title = rs.getString("title");
				Post post = new Post();
				post.setId(id);
				post.setUserId(userId);
				post.setTitle(title);
				posts.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return posts;
	}

	/**
	 * ɾ������
	 * 
	 * @author LG
	 */
	public void deletePost(String id) {
		try {
			Statement sm = mConnection.createStatement();
			String sql = "delete from posts where id='" + id + "'";
			sm.execute(sql);
			sql = "delete from comments where post_id='" + id + "'";
			sm.execute(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ɾ������
	 * 
	 * @author LG
	 */
	public void deleteComment(String date) {
		try {
			Statement sm = mConnection.createStatement();
			String sql = "delete from comments where date='" + date + "'";
			sm.execute(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
