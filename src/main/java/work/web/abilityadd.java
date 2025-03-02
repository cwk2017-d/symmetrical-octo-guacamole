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

@WebServlet("/abilityadd")
public class abilityadd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        String number = req.getParameter("number");
        String daily = req.getParameter("daily");
        String mental = req.getParameter("mental");
        String feel= req.getParameter("feel");
        String publics = req.getParameter("publics");
        String ability1 = req.getParameter("ability1");
        String changing = req.getParameter("changing");
        String ability2 = req.getParameter("ability2");
        String auditor1 = req.getParameter("auditor1");
        String auditor2 = req.getParameter("auditor2");
        String provider = req.getParameter("provider");
        String date= req.getParameter("date");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        int i=usermapper.abilityadd(number,daily,mental,feel,publics,ability1,changing,ability2,auditor1,auditor2,provider,date);
        Writer writer=resp.getWriter();
        sqlSession.commit();
        sqlSession.close();
        if(i>0){
            writer.write("<html><body>");
            writer.write("<form id='redirectForm' action='/work-demo/enter' method='post'>");
            writer.write("<input type='hidden' name='number' value='" + number + "' />");
            writer.write("</form>");
            writer.write("<script type='text/javascript'>");
            writer.write("document.getElementById('redirectForm').submit();");
            writer.write("</script>");
            writer.write("</body></html>");
        }else  writer.write("<html><body>");
        writer.write("<p>请重新填写...</p>");
        writer.write("<script type='text/javascript'>");
        writer.write("setTimeout(function() { window.location.href = './ability.html'; }, 3000);");
        writer.write("</script>");
        writer.write("</body></html>");
    }
}
