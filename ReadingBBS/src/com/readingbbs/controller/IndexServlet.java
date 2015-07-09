package com.readingbbs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readingbbs.bean.Post;
import com.readingbbs.bean.User;
import com.readingbbs.utils.PostDBUtil;
import com.readingbbs.utils.UserDBUtil;

public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String area = request.getParameter("area");
		// 获取帖子列表
		PostDBUtil postDBUtil = new PostDBUtil(area);
		ArrayList<Post> posts = postDBUtil.getPosts();
		request.setAttribute("area", area);
		request.setAttribute("posts", posts);
		// 跳转回index.jsp
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
