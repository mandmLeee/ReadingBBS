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
<title>重置密码</title>
<link href="CSS/mycss.css" rel="stylesheet" type="text/css">
<c:if test="${user==null }">
	<META http-equiv=refresh
		content="0;url=${pageContext.request.contextPath}/servlet/IndexServlet?area=writer" />
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
									height="40"> </a></td>
							<td width="570" align="right" style="padding-top: 2px;"><a
								href="/ReadingBBS/" class="top">首页</a>&nbsp;&nbsp;&nbsp;<a
								class="top">${user.id}</a>&nbsp;&nbsp;&nbsp;<a
								href="${pageContext.request.contextPath}/servlet/LogoutServlet"
								class="top">注销</a>
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
						重置密码
					</div>
					<c:if test="${error!=null}">
						<div class="problem">
							请解决以下问题然后再提交：
							<ul>
								<li>${error}</li>
							</ul>
						</div>
					</c:if>
					<div class="inner">
						<form method="post"
							action="${pageContext.request.contextPath}/servlet/ResetPwdServlet">
							<table cellpadding="4" cellspacing="0" border="0" width="100%">
								<tbody>
									<tr>
										<td width="120" align="right">旧密码</td>
										<td width="auto" align="left"><input type="password"
											class="sl" name="oldPwd" value="" autocorrect="off"
											spellcheck="false" autocapitalize="off">
										</td>
									</tr>
									<tr>
										<td width="120" align="right">新密码</td>
										<td width="auto" align="left"><input type="password"
											class="sl" name="newPwd" value="" autocorrect="off"
											spellcheck="false" autocapitalize="off">
										</td>
									</tr>
									<tr>
										<td width="120" align="right">确认密码</td>
										<td width="auto" align="left"><input type="password"
											class="sl" name="renewPwd" value="" autocorrect="off"
											spellcheck="false" autocapitalize="off">
										</td>
									</tr>

									<tr>
										<td width="120" align="right"></td>
										<td width="auto" align="left"><input type="hidden"
											name="userId" value="${user.id }"> <input
											type="submit" class="super normal button" value="提交">
										</td>
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