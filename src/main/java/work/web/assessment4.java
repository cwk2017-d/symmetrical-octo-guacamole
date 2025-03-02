package work.web;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import work.mapper.UserMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

@WebServlet("/assessment4")
public class assessment4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        String number = req.getParameter("number");
        int shenghuo = Integer.parseInt(req.getParameter("shenghuo"));
        int gongzuo = Integer.parseInt(req.getParameter("gongzuo"));
        int shikong = Integer.parseInt(req.getParameter("shikong"));
        int renwu = Integer.parseInt(req.getParameter("renwu"));
        int shejiao = Integer.parseInt(req.getParameter("shejiao"));
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        int a = usermapper.assessment4add(number, shenghuo, gongzuo, shikong, renwu, shejiao);
        Writer writer = resp.getWriter();
        sqlSession.commit();
        sqlSession.close();
        if (a > 0) {
            // 创建一个表单并自动提交以跳转到answer Servlet
            writer.write("<html><body>");
            writer.write("<form id='redirectForm' action='/work-demo/answer' method='post'>");
            writer.write("<input type='hidden' name='number' value='" + number + "' />");
            writer.write("</form>");
            writer.write("<script type='text/javascript'>");
            writer.write("document.getElementById('redirectForm').submit();");
            writer.write("</script>");
            writer.write("</body></html>");
        } else {
            writer.write("<html><body>");
            writer.write("<h2>添加失败，请重新输入</h2>");
            writer.write("<p>3秒后将跳转到主界面...</p>");
            writer.write("<script type='text/javascript'>");
            writer.write("setTimeout(function() { window.location.href = './screen.html'; }, 3000);");
            writer.write("</script>");
            writer.write("</body></html>");
        }
    }
}