package com.readingbbs.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.readingbbs.bean.User;

public class RegisterUtil {

	/**
	 * 判断注册信息是否可以通过注册
	 * 
	 * @return 返回错误信息列表
	 * @author LG
	 */
	public static Map<String, String> isPassedRegister(User user) {
		Map<String, String> errors = new HashMap<String, String>();

		if (user.getId().equals("")) {
			String error = "用户名不能为空";
			errors.put("idnull", error);
		}
		if (user.getPwd().equals("")) {
			String error = "密码不能为空";
			errors.put("pwdnull", error);
		}

		if (user.getId().equals("")) {
			String error = "姓名不能为空";
			errors.put("namenull", error);
		}
		if (user.getSex().equals("")) {
			String error = "性别不能为空";
			errors.put("sexnull", error);
		}
		if (user.getBirthday().equals("")) {
			String error = "出生日期不能为空";
			errors.put("birthdaynull", error);
		}
		if (user.getEmail().equals("")) {
			String error = "email不能为空";
			errors.put("emailnull", error);
		}

		return errors;
	}

}
