package com.readingbbs.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.readingbbs.bean.User;

public class RegisterUtil {

	/**
	 * �ж�ע����Ϣ�Ƿ����ͨ��ע��
	 * 
	 * @return ���ش�����Ϣ�б�
	 * @author LG
	 */
	public static Map<String, String> isPassedRegister(User user) {
		Map<String, String> errors = new HashMap<String, String>();

		if (user.getId().equals("")) {
			String error = "�û�������Ϊ��";
			errors.put("idnull", error);
		}
		if (user.getPwd().equals("")) {
			String error = "���벻��Ϊ��";
			errors.put("pwdnull", error);
		}

		if (user.getId().equals("")) {
			String error = "��������Ϊ��";
			errors.put("namenull", error);
		}
		if (user.getSex().equals("")) {
			String error = "�Ա���Ϊ��";
			errors.put("sexnull", error);
		}
		if (user.getBirthday().equals("")) {
			String error = "�������ڲ���Ϊ��";
			errors.put("birthdaynull", error);
		}
		if (user.getEmail().equals("")) {
			String error = "email����Ϊ��";
			errors.put("emailnull", error);
		}

		return errors;
	}

}
