<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <%
        HttpSession Session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
        }
    %>
    <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
    <a href="LogoutServlet">Logout</a>
</body>
</html>
    