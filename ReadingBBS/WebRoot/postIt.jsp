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
<title>发帖</title>
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
					<div class="cell">
						<a href="/ReadingBBS/index.jsp">书坛</a> <span class="chevron">&nbsp;›&nbsp;</span>
						发布新帖
					</div>
					<form method="post"
						action="${pageContext.request.contextPath}/servlet/PostItServlet">
						<div class="cell">
							<div class="fr fade">120</div>
							主题标题
						</div>
						<div class="cell" style="padding: 0px; background-color: #fff;">
							<textarea class="msl" rows="1" maxlength="120" name="title"
								autofocus="autofocus" placeholder="请输入主题标题">${oldTitle}</textarea>
						</div>
						<div class="cell">
							<div class="fr fade">20000</div>
							正文
						</div>
						<div class="cell" style="padding: 0px; background-color: #fff;">
							<textarea class="msl" rows="15" maxlength="20000" name="content">${oldContent}</textarea>
						</div>

						<div class="cell">
							<input type="radio" name="area" value="writer" checked="checked" />作家区
							<input type="radio" name="area" value="review" />书评区 <input
								type="radio" name="area" value="recommend" />推书区 <input
								type="radio" name="area" value="trade" />交易区 <input
								type="radio" name="area" value="ask" />问与答
						</div>

						<div class="cell">
							<input type="hidden" name="userId" value="${user.id }"> <input
								type="submit" value="发布主题" class="super normal button">&nbsp;
							<c:if test="${post_error!=null}">
								<span>${post_error}</span>
							</c:if>
						</div>


					</form>

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