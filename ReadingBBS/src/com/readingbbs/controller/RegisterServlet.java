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
 * ���Ʋ㣬����ע����Ϣ������ע������
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
		// ��ȡ���û���Ϣ
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
			String error = "ȷ�����벻��Ϊ��";
			errors.put("pwd_renull", error);
		}
		if (!pwd.equals(pwd_re) && !pwd.equals("") && !pwd_re.equals("")) {
			String error = "�����������벻ͬ";
			errors.put("pwderror", error);
		}
		// �жϸ��û����Ƿ�ע��
		UserDBUtil userDBUtil = new UserDBUtil(user);
		if (userDBUtil.isRegistered()) {
			String error = "���û��Ѿ���ע��";
			errors.put("iderror", error);
		}

		if (errors.size() > 0) { // ˵��δͨ��ע�����
			// ��������Ϣ�б��ͻ�register.jspҳ������ʾ
			request.setAttribute("errors", errors);
			request.setAttribute("oldinfo", user); // ��֮ǰ��õı����ع�ȥ
			// ��ת��register.jsp
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
		} else { // ͨ��ע�����
					// �������ݿ�
			if (userDBUtil.registerUser()) {
				// ��¼�����ص���ҳ
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
			} else {// ���ݿ����ʧ��
				String message = String
						.format("���ݿ��������ʧ�ܣ���������»ص�ע��ҳ�棡<meta http-equiv='refresh' content='3;url=%s'",
								request.getContextPath() + "/register.jsp");
				request.setAttribute("message", message);
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);
			}
		}

	}

}
