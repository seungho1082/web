<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021-05-08
  Time: 오후 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="kr.mjc.seungho.web.dao.User" %>
<!DOCTYPE html>
<% User user = (User) session.getAttribute("USER"); %>
<html>
<body>
<h3>사용자 정보</h3>
<p><%= user %>
</p>
</body>
</html>