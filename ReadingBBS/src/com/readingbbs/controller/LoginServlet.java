package com.readingbbs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readingbbs.bean.User;
import com.readingbbs.utils.UserDBUtil;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 获取表单用户信息
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		User user = new User();
		user.setId(id);
		user.setPwd(pwd);
		// 判断用户名和密码是否匹配
		UserDBUtil userDBUtil = new UserDBUtil(user);
		if (userDBUtil.isPassedLogin()) { // 通过登录
			// 登录成功后，完整user
			userDBUtil.completeUser();
			if (user.getAuthority().equals("normal")) { // 普通用户
				// 将用户存储到session中
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
			} else {
				// 将用户存储到session中
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/admin.jsp").forward(request,
						response);
			}
		} else { // 登录失败
					// 将错误信息列表发送回register.jsp页面中显示
			request.setAttribute("error", "用户名和密码无法匹配");
			request.setAttribute("oldid", user.getId()); // 把之前填好的表单返回过去
			// 跳转回register.jsp
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
