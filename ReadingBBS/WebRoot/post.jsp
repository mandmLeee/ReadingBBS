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
<title>书坛</title>
<link href="CSS/mycss.css" rel="stylesheet" type="text/css">
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
							<td width="570" align="right" style="padding-top: 2px;"><c:if
									test="${user==null}">
									<a href="/ReadingBBS/" class="top">首页</a>&nbsp;&nbsp;&nbsp;<a
										href="/ReadingBBS/register.jsp" class="top">注册</a>&nbsp;&nbsp;&nbsp;<a
										href="/ReadingBBS/login.jsp" class="top">登录</a>
								</c:if> <c:if test="${user!=null}">
									<a href="/ReadingBBS/" class="top">首页</a>&nbsp;&nbsp;&nbsp;<a
										class="top">${user.id}</a>&nbsp;&nbsp;&nbsp;<a
										href="${pageContext.request.contextPath}/servlet/LogoutServlet"
										class="top">注销</a>
								</c:if></td>
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
				<div class="box" style="border-bottom: 0px;">
					<div class="header">
						<c:if test="${post.area=='writer'}">
							<a href="/ReadingBBS/index.jsp">书坛</a>
							<span class="chevron">&nbsp;›&nbsp;</span>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=writer">作家</a>
						</c:if>
						<c:if test="${post.area=='review'}">
							<a href="/ReadingBBS/index.jsp">书坛</a>
							<span class="chevron">&nbsp;›&nbsp;</span>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=review">书评</a>
						</c:if>
						<c:if test="${post.area=='recommend'}">
							<a href="/ReadingBBS/index.jsp">书坛</a>
							<span class="chevron">&nbsp;›&nbsp;</span>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=recommend">推书</a>
						</c:if>
						<c:if test="${post.area=='trade'}">
							<a href="/ReadingBBS/index.jsp">书坛</a>
							<span class="chevron">&nbsp;›&nbsp;</span>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=trade">交易</a>
						</c:if>
						<c:if test="${post.area=='ask'}">
							<a href="/ReadingBBS/index.jsp">书坛</a>
							<span class="chevron">&nbsp;›&nbsp;</span>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=ask">问与答</a>
						</c:if>

						<div class="sep10"></div>
						<h1>${post.title}</h1>
						<small class="gray"><a>${post.userId }</a>&nbsp;&nbsp;&nbsp;${post.date}</small>
					</div>

					<div class="cell">
						<div class="topic_content">
							<br> <br>${post.content }<br> <br>
						</div>
					</div>
				</div>
				<div class="sep20"></div>

				<div class="box">
					<div class="cell">
						<div class="fr" style="margin: -3px -5px 0px 0px;"></div>
						<span class="gray">${post.commentNum} 回复</span>
					</div>

					<c:forEach var="comment" items="${post.comments}">
						<div class="cell">
							<table cellpadding="0" cellspacing="0" border="0" width="100%">
								<tbody>
									<tr>
										<td width="10" valign="top"></td>
										<td width="auto" valign="top" align="left">
											<div class="sep3"></div> <strong><a class="dark">${comment.userId
													}</a> </strong>&nbsp; &nbsp;<span class="fade small">${comment.date}</span>
											<div class="sep5"></div>
											<div class="reply_content">${comment.content }</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</c:forEach>
				</div>
				<div class="sep20"></div>

				<c:if test="${user!=null }">
					<div class="box">
						<div class="cell">
							<div class="fr">
								<a
									href="${pageContext.request.contextPath}/servlet/PostServlet?postId=${post.id}"><strong>↑</strong>
									回到顶部</a>
							</div>
							添加一条新回复
						</div>
						<div class="cell">
							<form method="post"
								action="${pageContext.request.contextPath}/servlet/CommentServlet">
								<textarea name="content" maxlength="10000" class="mll"
									style="overflow: hidden; word-wrap: break-word; resize: none; height: 112px;"></textarea>
								<div class="sep10"></div>
								<div class="fr">
									<div class="sep5"></div>
									<span class="gray">请尽量让自己的回复能够对别人有帮助</span>
								</div>
								<input type="hidden" name="postId" value="${post.id }">
								<input type="hidden" name="userId" value="${user.id }">
								<input type="submit" value="回复" class="super normal button">&nbsp;
								<c:if test="${comment_error!=null}">
									<span>${comment_error}</span>
								</c:if>
							</form>
						</div>

						<div class="inner">
							<div class="fr">
								<a href="/ReadingBBS/index.jsp">← 书坛</a>
							</div>
							&nbsp;
						</div>
					</div>
				</c:if>


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