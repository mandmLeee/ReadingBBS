package com.readingbbs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readingbbs.bean.User;
import com.readingbbs.utils.UserDBUtil;

public class ResetPwdServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		String renewPwd = request.getParameter("renewPwd");
		User user = new User();
		user.setId(userId);
		user.setPwd(oldPwd);
		UserDBUtil userDBUtil = new UserDBUtil(user);
		if (!userDBUtil.isPassedLogin()) {
			request.setAttribute("error", "旧密码错误");
			request.getRequestDispatcher("/resetPwd.jsp").forward(request,
					response);
			return;
		}
		if (newPwd.equals("")) {
			request.setAttribute("error", "新密码为空");
			request.getRequestDispatcher("/resetPwd.jsp").forward(request,
					response);
			return;
		}

		if (!newPwd.equals(renewPwd)) {
			request.setAttribute("error", "两次密码输入不同");
			request.getRequestDispatcher("/resetPwd.jsp").forward(request,
					response);
			return;
		}

		// 更新数据库
		user.setPwd(newPwd);
		userDBUtil.resetPwd();
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
