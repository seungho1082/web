package kr.mjc.seungho.web.mvc;

import kr.mjc.seungho.web.dao.Article;
import kr.mjc.seungho.web.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class ArticleController {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    /**
     * 게시글 목록 화면
     */
    public void articleList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("articleList", articleDao.listArticles(0, 100));

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleList.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 상세보기 화면
     */

    public void articleInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleInfo.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 등록 화면
     */

    public void articleForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleForm.jsp")
                .forward(request, response);
    }


    /**
     * 게시글 등록 액션
     */

    public void addArticle(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setUserId(Integer.parseInt(request.getParameter("userId")));
        article.setName(request.getParameter("name"));

        try {
            articleDao.addArticle(article);
            response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");
        } catch (DuplicateKeyException e) {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/articleForm?msg=Duplicate title");
        }
    }

    /**
     * 게시글 삭제 화면
     */

    public void deleteArticle(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleDelect.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 삭제 액션
     * @param request
     * @param response
     * @throws IOException
     */

    public void articleDelect(HttpServletRequest request, HttpServletResponse response)
            throws IOException{

        try {
            articleDao.deleteArticle(Integer.parseInt(request.getParameter("userId")),
                    Integer.parseInt(request.getParameter("articleId")));
            response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/articleDelect?msg=Check articleId or userId");
        }
    }

    /**
     * 게시글 수정 화면
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */

    public void updateArticle(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleUpdate.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 수정 액션
     * @param request
     * @param response
     * @throws IOException
     */

    public void articleUpdate(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.getArticleId();
        article.getUserId();

        try {
            articleDao.updateArticle(article);
            response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/articleUpdate?msg=Check articleId or userId");
        }
    }
}