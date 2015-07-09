package com.readingbbs.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readingbbs.bean.Post;
import com.readingbbs.utils.PostDBUtil;

public class PostItServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String area = request.getParameter("area");
		if (title.equals("")) { // 主题标题为空
			request.setAttribute("oldContent", content);
			request.setAttribute("post_error", "主题标题不能为空");
			// 跳转到postIt.jsp
			request.getRequestDispatcher("/postIt.jsp").forward(request,
					response);
			return;
		}
		if (content.equals("")) { // 正文为空
			request.setAttribute("oldTitle", title);
			request.setAttribute("post_error", "正文不能为空");
			// 跳转到postIt.jsp
			request.getRequestDispatcher("/postIt.jsp").forward(request,
					response);
			return;
		}

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		String date = dateFormat.format(now);

		Post post = new Post();
		post.setId(date);
		post.setArea(area);
		post.setTitle(title);
		post.setContent(content);
		post.setDate(date);
		post.setUserId(userId);
		post.setCommentNum(0);

		PostDBUtil postDBUtil = new PostDBUtil();
		postDBUtil.insertPost(post);

		request.setAttribute("post", post);
		// 跳转到post.jsp
		request.getRequestDispatcher("/post.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
