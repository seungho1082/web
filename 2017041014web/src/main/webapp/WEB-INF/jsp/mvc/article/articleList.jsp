<%@ page import="kr.mjc.seungho.web.dao.Article" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<body>
<nav><a href="./articleForm">게시글 작성</a> <a href="./delectArticle">게시글 삭제</a> <a href="./updateArticle">게시글 수정</a></nav>
<h3>게시글 목록</h3>
<%
    List<Article> articleList = (List<Article>) request.getAttribute("articleList");
    for (Article article : articleList) {%>
<p><%= article %>
</p>
<%
    }
%>
</body>
</html>