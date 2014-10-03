<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome:
<br/>
<p>Username: <c:out value="${login.username}" /></p>
<p>password: <c:out value="${login.password}" /></p>
<br/>
<h3>List of Polls</h3>
<c:forEach items="${pollList}" var="item">
   <input type="radio" name="poll" value="${item.title}">${item.title}<br>
</c:forEach>

</body>
</html>