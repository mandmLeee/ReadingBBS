package com.readingbbs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readingbbs.bean.Post;
import com.readingbbs.utils.PostDBUtil;

public class PostServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String postId = request.getParameter("postId");
		PostDBUtil postDBUtil = new PostDBUtil();
		Post post = postDBUtil.getPost(postId);
		request.setAttribute("post", post);
		String commentError = (String) request.getAttribute("comment_error");
		if (commentError != null) {
			request.setAttribute("comment_error", commentError);
		}

		// Ìø×ª»Øpost.jsp
		request.getRequestDispatcher("/post.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
