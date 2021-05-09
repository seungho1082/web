<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021-05-08
  Time: 오후 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h3>로그인</h3>
<form action="login" method="post">
    <p><input type="email" name="email" placeholder="이메일" required autofocus/></p>
    <p><input type="password" name="password" placeholder="비밀번호" required/></p>
    <p>
        <button type="submit">로그인</button>
    </p>
</form>
<p style="color:#ff0000;"><%= Optional.ofNullable(request.getParameter("msg"))
        .orElse("")%>
</p>
</body>
</html>