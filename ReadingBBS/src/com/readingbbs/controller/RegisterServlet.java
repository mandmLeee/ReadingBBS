package com.readingbbs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readingbbs.bean.User;
import com.readingbbs.utils.RegisterUtil;
import com.readingbbs.utils.UserDBUtil;

/**
 * 控制层，接收注册信息，处理注册请求
 * 
 * @author LG
 */
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 获取表单用户信息
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String pwd_re = request.getParameter("pwd_re");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		User user = new User();
		user.setId(id);
		user.setPwd(pwd);
		user.setName(name);
		user.setSex(sex);
		user.setBirthday(birthday);
		user.setEmail(email);
		Map<String, String> errors = RegisterUtil.isPassedRegister(user);
		if (pwd_re.equals("")) {
			String error = "确认密码不能为空";
			errors.put("pwd_renull", error);
		}
		if (!pwd.equals(pwd_re) && !pwd.equals("") && !pwd_re.equals("")) {
			String error = "两次密码输入不同";
			errors.put("pwderror", error);
		}
		// 判断该用户名是否被注册
		UserDBUtil userDBUtil = new UserDBUtil(user);
		if (userDBUtil.isRegistered()) {
			String error = "该用户已经被注册";
			errors.put("iderror", error);
		}

		if (errors.size() > 0) { // 说明未通过注册审核
			// 将错误信息列表发送回register.jsp页面中显示
			request.setAttribute("errors", errors);
			request.setAttribute("oldinfo", user); // 把之前填好的表单返回过去
			// 跳转回register.jsp
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
		} else { // 通过注册审核
					// 更新数据库
			if (userDBUtil.registerUser()) {
				// 登录并返回到首页
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
			} else {// 数据库更新失败
				String message = String
						.format("数据库更新数据失败，三秒后重新回到注册页面！<meta http-equiv='refresh' content='3;url=%s'",
								request.getContextPath() + "/register.jsp");
				request.setAttribute("message", message);
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);
			}
		}

	}

}
