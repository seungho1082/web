<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h3>게시글 삭제</h3>
<form action="articleDelect" method="post">
    <p><input type="number" name="articleId" placeholder="게시글 번호를 입력하세요" required autofocus/></p>
    <p><input type="number" name="userid" placeholder="아이디를 입력하세요" required></p>
    <p>
        <button type="submit">삭제하기</button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
        .orElse("")%>
</p>
</body>
</html>