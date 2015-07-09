<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%--为了避免在jsp页面中出现java代码，这里引入jstl标签库，利用jstl标签库提供的标签来做一些逻辑判断处理 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>书坛</title>
<script type="text/javascript">
	function doLogout() {
		// 注销
		window.location.href = "${pageContext.request.contextPath}/servlet/LogoutServlet";
	}
</script>
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
			<div id="rightbar">
				<div class="sep20"></div>

				<c:if test="${user==null}">
					<div class="box">
						<div class="cell">
							<strong>书坛</strong>
							<div class="sep5"></div>
							<span class="fade">书中有乐趣</span>
						</div>

						<div class="inner">
							<div class="sep5"></div>
							<div align="center">
								<a href="/ReadingBBS/register.jsp" class="super normal button">现在注册</a>
								<div class="sep5"></div>
								<div class="sep10"></div>
								已注册用户请 &nbsp;<a href="/ReadingBBS/login.jsp">登录</a>
							</div>
						</div>
					</div>
				</c:if>

				<c:if test="${user!=null}">
					<div class="box">
						<div class="cell">
							<strong>${user.name }</strong>
							<div class="sep5"></div>
							<span class="fade">${user.id
								}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
								href="/ReadingBBS/resetPwd.jsp">重置密码</a> </span>
						</div>

						<div class="inner">
							<div class="sep5"></div>
							<div align="center">
								<a href="/ReadingBBS/postIt.jsp" class="super normal button">发帖</a>
							</div>
						</div>
					</div>
				</c:if>





			</div>
			<div id="main">
				<div class="sep20"></div>
				<div class="box">
					<div class="inner"
						style="background-color: #fff; border-top-left-radius: 3px; border-top-right-radius: 3px;"
						id="Tabs">
						<c:if test="${area==null}">
							<META http-equiv=refresh
								content="0;url=${pageContext.request.contextPath}/servlet/IndexServlet?area=writer">

						</c:if>
						<c:if test="${area=='writer'}">
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=writer"
								class="tab_current">作家</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=review"
								class="tab">书评</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=recommend"
								class="tab">推书</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=trade"
								class="tab">交易</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=ask"
								class="tab">问与答</a>
						</c:if>
						<c:if test="${area=='review'}">
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=writer"
								class="tab">作家</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=review"
								class="tab_current">书评</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=recommend"
								class="tab">推书</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=trade"
								class="tab">交易</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=ask"
								class="tab">问与答</a>
						</c:if>
						<c:if test="${area=='recommend'}">
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=writer"
								class="tab">作家</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=review"
								class="tab">书评</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=recommend"
								class="tab_current">推书</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=trade"
								class="tab">交易</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=ask"
								class="tab">问与答</a>
						</c:if>
						<c:if test="${area=='trade'}">
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=writer"
								class="tab">作家</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=review"
								class="tab">书评</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=recommend"
								class="tab">推书</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=trade"
								class="tab_current">交易</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=ask"
								class="tab">问与答</a>
						</c:if>
						<c:if test="${area=='ask'}">
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=writer"
								class="tab">作家</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=review"
								class="tab">书评</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=recommend"
								class="tab">推书</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=trade"
								class="tab">交易</a>
							<a
								href="${pageContext.request.contextPath}/servlet/IndexServlet?area=ask"
								class="tab_current">问与答</a>
						</c:if>
					</div>
					<div class="sep20"></div>
					<c:if test="${posts!=null }">
						<c:forEach var="post" items="${posts }">
							<div class="cell item" style="">
								<div style="position: absolute; margin: -10px -10px 0px 650px;"></div>
								<table cellpadding="0" cellspacing="0" border="0" width="100%">
									<tbody>
										<tr>
											<td width="auto" valign="middle"><span
												class="item_title"> <a
													href="${pageContext.request.contextPath}/servlet/PostServlet?postId=${post.id}">${post.title}</a>
											</span>

												<div class="sep5"></div> <span class="small fade"> <strong><a>${post.userId
															}</a> </strong> &nbsp;•&nbsp; ${post.date } </span>
											</td>

											<td width="70" align="right" valign="middle"><a href=""
												class="count_livid">${post.commentNum}</a>
											</td>
										</tr>
									</tbody>
								</table>
							</div>

						</c:forEach>
					</c:if>


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