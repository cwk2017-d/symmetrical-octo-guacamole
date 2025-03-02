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

@WebServlet("/assessment1")
public class assessment1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        String number = req.getParameter("number");
        int jinshi=Integer.parseInt(req.getParameter("jinshi"));
        int xizao=Integer.parseInt(req.getParameter("xizao"));
        int xiushi=Integer.parseInt(req.getParameter("xiushi"));
        int chuanyi=Integer.parseInt(req.getParameter("chuanyi"));
        int dabian=Integer.parseInt(req.getParameter("dabian"));
        int xiaobian=Integer.parseInt(req.getParameter("xiaobian"));
        int ruce=Integer.parseInt(req.getParameter("ruce"));
        int chuangyi=Integer.parseInt(req.getParameter("chuangyi"));
        int zoulu=Integer.parseInt(req.getParameter("zoulu"));
        int shanglouti=Integer.parseInt(req.getParameter("shanglouti"));
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        int a=usermapper.assessment1add(number,jinshi,xizao,xiushi,chuanyi,dabian,xiaobian,ruce,chuangyi,zoulu,shanglouti);
        Writer writer=resp.getWriter();
        sqlSession.commit();
        sqlSession.close();
        if(a>0){
            writer.write("<html><body>");
            writer.write("<p>1秒后将跳转到精神状态评估表...</p>");
            writer.write("<script type='text/javascript'>");
            writer.write("setTimeout(function() { window.location.href = './assessment2.html'; }, 1000);");
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
