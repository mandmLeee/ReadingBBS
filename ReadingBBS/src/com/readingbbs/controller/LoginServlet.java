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
		// ��ȡ���û���Ϣ
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		User user = new User();
		user.setId(id);
		user.setPwd(pwd);
		// �ж��û����������Ƿ�ƥ��
		UserDBUtil userDBUtil = new UserDBUtil(user);
		if (userDBUtil.isPassedLogin()) { // ͨ����¼
			// ��¼�ɹ�������user
			userDBUtil.completeUser();
			if (user.getAuthority().equals("normal")) { // ��ͨ�û�
				// ���û��洢��session��
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
			} else {
				// ���û��洢��session��
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/admin.jsp").forward(request,
						response);
			}
		} else { // ��¼ʧ��
					// ��������Ϣ�б��ͻ�register.jspҳ������ʾ
			request.setAttribute("error", "�û����������޷�ƥ��");
			request.setAttribute("oldid", user.getId()); // ��֮ǰ��õı����ع�ȥ
			// ��ת��register.jsp
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
