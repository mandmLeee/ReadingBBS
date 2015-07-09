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
			request.setAttribute("error", "���������");
			request.getRequestDispatcher("/resetPwd.jsp").forward(request,
					response);
			return;
		}
		if (newPwd.equals("")) {
			request.setAttribute("error", "������Ϊ��");
			request.getRequestDispatcher("/resetPwd.jsp").forward(request,
					response);
			return;
		}

		if (!newPwd.equals(renewPwd)) {
			request.setAttribute("error", "�����������벻ͬ");
			request.getRequestDispatcher("/resetPwd.jsp").forward(request,
					response);
			return;
		}

		// �������ݿ�
		user.setPwd(newPwd);
		userDBUtil.resetPwd();
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
