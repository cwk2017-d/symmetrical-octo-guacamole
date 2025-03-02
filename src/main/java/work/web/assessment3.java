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

@WebServlet("/assessment3")
public class assessment3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        String number = req.getParameter("number");
        int yishi = Integer.parseInt(req.getParameter("yishi"));
        int shili = Integer.parseInt(req.getParameter("shili"));
        int tinli = Integer.parseInt(req.getParameter("tinli"));
        int goutong = Integer.parseInt(req.getParameter("goutong"));
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        int a=usermapper.assessment3add(number,yishi,shili,tinli,goutong);
        Writer writer=resp.getWriter();
        sqlSession.commit();
        sqlSession.close();

        if(a>0){
            writer.write("<html><body>");
            writer.write("<p>1秒后将跳转到社会参与评估表...</p>");
            writer.write("<script type='text/javascript'>");
            writer.write("setTimeout(function() { window.location.href = './assessment4.html'; }, 1000);");
            writer.write("</script>");
            writer.write("</body></html>");
        }else
        {
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
