<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>注册</title>
<link href="CSS/mycss.css" rel="stylesheet" type="text/css">
<c:if test="${user!=null }">
	<META http-equiv=refresh
		content="0;url=${pageContext.request.contextPath}/servlet/IndexServlet?area=writer"/>
</c:if>
</head>

<body>


	<div id="top">
		<div class="content">
			<div style="padding-top: 6px;">
				<table cellpadding="0" cellspacing="0" border="0" width="100%">
					<tbody>
						<tr>
							<td width="110" align="left"><a> <img
									src="Images\logo.png" border="0" align="default" width="100"
									height="40"> </a>
							</td>
							<td width="570" align="right" style="padding-top: 2px;"><a
								href="/ReadingBBS/" class="top">首页</a>&nbsp;&nbsp;&nbsp;<a
								href="/ReadingBBS/register.jsp" class="top">注册</a>&nbsp;&nbsp;&nbsp;<a
								href="/ReadingBBS/login.jsp" class="top">登录</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div id="wrapper">
		<div class="content">
			<div id="leftbar"></div>
			<div id="rightbar"></div>
			<div id="main">
				<div class="sep20"></div>
				<div class="box">
					<div class="header">
						<a href="/ReadingBBS/">书坛</a> <span class="chevron">&nbsp;›&nbsp;</span>
						注册
					</div>
					<c:if test="${errors!=null}">
						<div class="problem">
							请解决以下问题然后再提交：
							<ul>
								<c:if test="${errors.idnull!=null}">
									<li>${errors.idnull}</li>
								</c:if>
								<c:if test="${errors.pwdnull!=null}">
									<li>${errors.pwdnull}</li>
								</c:if>
								<c:if test="${errors.pwd_renull!=null}">
									<li>${errors.pwd_renull}</li>
								</c:if>
								<c:if test="${errors.namenull!=null}">
									<li>${errors.namenull}</li>
								</c:if>
								<c:if test="${errors.sexnull!=null}">
									<li>${errors.sexnull}</li>
								</c:if>
								<c:if test="${errors.birthdaynull!=null}">
									<li>${errors.birthdaynull}</li>
								</c:if>
								<c:if test="${errors.emailnull!=null}">
									<li>${errors.emailnull}</li>
								</c:if>
								<c:if test="${errors.pwderror!=null}">
									<li>${errors.pwderror}</li>
								</c:if>
								<c:if test="${errors.iderror!=null}">
									<li>${errors.iderror}</li>
								</c:if>
							</ul>
						</div>
					</c:if>
					<div class="inner">
						<form method="post"
							action="${pageContext.request.contextPath}/servlet/RegisterServlet">
							<table cellpadding="4" cellspacing="0" border="0" width="100%">
								<tbody>
									<tr>
										<td width="120" align="right" valign="top"><div
												class="sep5"></div>用户名</td>
										<td width="auto" align="left"><input type="text"
											class="sl" name="id" value="${oldinfo.id }" autocorrect="off"
											spellcheck="false" autocapitalize="off">
											<div class="sep5"></div> <span class="fade">请使用半角的 a-z
												或数字 0-9</span></td>
									</tr>
									<tr>
										<td width="120" align="right">密码</td>
										<td width="auto" align="left"><input type="password"
											class="sl" name="pwd" value="" autocorrect="off"
											spellcheck="false" autocapitalize="off"></td>
									</tr>
									<tr>
										<td width="120" align="right">确认密码</td>
										<td width="auto" align="left"><input type="password"
											class="sl" name="pwd_re" value="" autocorrect="off"
											spellcheck="false" autocapitalize="off"></td>
									</tr>

									<tr>
										<td width="120" align="right" valign="top"><div
												class="sep5"></div>姓名</td>
										<td width="auto" align="left"><input type="text"
											class="sl" name="name" value="${oldinfo.name }"
											autocorrect="off" spellcheck="false" autocapitalize="off">
											<div class="sep5"></div>
										</td>
									</tr>

									<tr>
										<td width="120" align="right" valign="top"><div
												class="sep5"></div>性别</td>
										<td width="auto" align="left"><input type="text"
											class="sl" name="sex" value="${oldinfo.sex }"
											autocorrect="off" spellcheck="false" autocapitalize="off">
											<div class="sep5"></div>
										</td>
									</tr>

									<tr>
										<td width="120" align="right" valign="top"><div
												class="sep5"></div>出生日期</td>
										<td width="auto" align="left"><input type="text"
											class="sl" name="birthday" value="${oldinfo.birthday }"
											autocorrect="off" spellcheck="false" autocapitalize="off">
											<div class="sep5"></div> <span class="fade">请使用YYYY-MM-DD格式</span>
										</td>
									</tr>

									<tr>
										<td width="120" align="right" valign="top"><div
												class="sep5"></div>电子邮件</td>
										<td width="auto" align="left"><input type="email"
											class="sl" name="email" value="${oldinfo.email }"
											autocorrect="off" spellcheck="false" autocapitalize="off">
											<div class="sep5"></div> <span class="fade">请使用真实电子邮箱注册，我们不会将你的邮箱地址分享给任何人</span>
										</td>
									</tr>
									<tr>
										<td width="120" align="right"></td>
										<td width="auto" align="left"><input type="submit"
											class="super normal button" value="注册"></td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="c"></div>
		<div class="sep20"></div>
	</div>
	<div id="bottom">
		<div class="sep20"></div>
		powered by LG
	</div>
</body>
</html>