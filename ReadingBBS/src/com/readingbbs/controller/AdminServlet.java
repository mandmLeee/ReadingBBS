package com.readingbbs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readingbbs.bean.Comment;
import com.readingbbs.bean.Post;
import com.readingbbs.bean.User;
import com.readingbbs.utils.PostDBUtil;
import com.readingbbs.utils.UserDBUtil;

public class AdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		} else {
			if (!user.getAuthority().equals("admin")) {
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				return;
			}
		}

		String area = request.getParameter("area");
		request.setAttribute("area", area);
		if (area != null) {
			if (area.equals("users")) {
				// ��ȡ�����û��б�
				UserDBUtil userDBUtil = new UserDBUtil();
				ArrayList<User> users = userDBUtil.getAllUsers();
				request.setAttribute("users", users);
				// ��ת��admin.jsp
				request.getRequestDispatcher("/admin.jsp").forward(request,
						response);
				return;
			}
			if (area.equals("posts")) {
				// ��ȡ���������б�
				PostDBUtil postDBUtil = new PostDBUtil();
				ArrayList<Post> posts = postDBUtil.getAllPosts();
				request.setAttribute("posts", posts);
				// ��ת��admin.jsp
				request.getRequestDispatcher("/admin.jsp").forward(request,
						response);
				return;
			}

			if (area.equals("comments")) {
				// ��ȡ���������б�
				PostDBUtil postDBUtil = new PostDBUtil();
				ArrayList<Comment> comments = postDBUtil.getAllComments();
				request.setAttribute("comments", comments);
				// ��ת��admin.jsp
				request.getRequestDispatcher("/admin.jsp").forward(request,
						response);
				return;
			}
		}

		String userId = request.getParameter("deleteUser");
		if (userId != null) {
			// ɾ�����û�
			UserDBUtil userDBUtil = new UserDBUtil();
			userDBUtil.deleteUser(userId);
			request.setAttribute("area", "users");
			// ��ת��admin.jsp
			request.getRequestDispatcher("/servlet/AdminServlet?area=users")
					.forward(request, response);
			return;
		}

		String postId = request.getParameter("deletePost");
		if (postId != null) {
			// ɾ�������Ӻ͸����ӵ�����
			PostDBUtil postDBUtil = new PostDBUtil();
			postDBUtil.deletePost(postId);
			request.setAttribute("area", "posts");
			// ��ת��admin.jsp
			request.getRequestDispatcher("/servlet/AdminServlet?area=posts")
					.forward(request, response);
			return;
		}

		String date = request.getParameter("deleteComment");
		if (date != null) {
			// ɾ��������
			PostDBUtil postDBUtil = new PostDBUtil();
			postDBUtil.deleteComment(date);
			request.setAttribute("area", "comments");
			// ��ת��admin.jsp
			request.getRequestDispatcher("/servlet/AdminServlet?area=comments")
					.forward(request, response);
			return;
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
