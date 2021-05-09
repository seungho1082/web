<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h3>게시글 작성</h3>
<form action="addArticle" method="post">
    <p>
        <input type="text" name="title" placeholder="제목" required autofocus/><br>
        <textarea name="content" cols = "50" rows = "4"></textarea><br>
        <input type="text" name="userId" placeholder="아이디를 입력하세요" required/>
        <input type="text" name="name" placeholder="이름을 입력하세요" required><br>
    </p>
    <p>
        <button type="submit">작성</button>
        <button type="reset">초기화</button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
        .orElse("")%>
</p>
</body>
</html>