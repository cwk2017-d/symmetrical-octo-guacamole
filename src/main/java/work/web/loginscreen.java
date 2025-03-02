package work.web;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import work.mapper.UserMapper;
import work.pojo.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

@WebServlet("/login")
public class loginscreen extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        String number = req.getParameter("number");
        String password = req.getParameter("password");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        login l=usermapper.selectlogin(number,password);
        Writer writer = resp.getWriter();
        sqlSession.commit();
        sqlSession.close();
        if(l!=null){
            writer.write("<html><body>");
            writer.write("<h2>登录成功</h2>");
            writer.write("<p>3秒后将跳转到主页面...</p>");
            writer.write("<script type='text/javascript'>");
            writer.write("setTimeout(function() { window.location.href = './screen.html'; }, 3000);");
            writer.write("</script>");
            writer.write("</body></html>");
        }else {
            writer.write("<html><body>");
            writer.write("<h2>登录失败，请重新输入</h2>");
            writer.write("<p>3秒后将跳转到登录界面...</p>");
            writer.write("<script type='text/javascript'>");
            writer.write("setTimeout(function() { window.location.href = './login.html'; }, 3000);");
            writer.write("</script>");
            writer.write("</body></html>");
        }
    }
}
