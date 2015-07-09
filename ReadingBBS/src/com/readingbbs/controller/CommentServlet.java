package com.readingbbs.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readingbbs.bean.Comment;
import com.readingbbs.utils.PostDBUtil;

public class CommentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String postId = request.getParameter("postId");
		String content = request.getParameter("content");

		if (content.equals("")) { // 评论内容为空
			request.setAttribute("oldContent", content);
			request.setAttribute("comment_error", "评论内容不能为空");
			// 跳转到PostServlet
			String url = "/servlet/PostServlet?postId=" + postId;
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}
		// 数据库操作,保存comment
		Comment comment = new Comment();
		comment.setPostId(postId);
		comment.setUserId(userId);
		comment.setContent(content);
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		String date = dateFormat.format(now);
		comment.setDate(date);
		PostDBUtil postDBUtil = new PostDBUtil();
		postDBUtil.insertComment(comment);
		// 跳转到PostServlet
		String url = "/servlet/PostServlet?postId=" + postId;
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
