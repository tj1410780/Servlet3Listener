<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.mengdi.sessionlistener.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
当前在线人数：<%= request.getServletContext().getAttribute("userNumber")%><br/>
<%ArrayList<User> userList = (ArrayList<User>)request.getServletContext().getAttribute("userList");
	if (userList != null) {
		for (int i = 0; i < userList.size(); i++) {
			com.mengdi.sessionlistener.User user = userList.get(i);
			%>
			IP:<%=user.getIp()%>,  FirstTime:<%=user.getFirstTime()%>,  SessionId:<%=user.getSessionId() %><br/>
			<% 
		}
	}
%>
</body>
</html>