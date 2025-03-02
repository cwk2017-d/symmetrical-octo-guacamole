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

@WebServlet("/informationadd")
public class informationadd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        String date = req.getParameter("date");
        String reason = req.getParameter("reason");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String number = req.getParameter("number");
        String cordnumber = req.getParameter("cordnumber");
        String nation=req.getParameter("nation");
        String culture=req.getParameter("culture");
        String religion=req.getParameter("religion");
        String marrystate=req.getParameter("marrystate");
        String livestate=req.getParameter("livestate");
        String disease_1=req.getParameter("disease_1");
        String disease_2=req.getParameter("disease_2");
        String disease_3=req.getParameter("disease_3");
        String accident_1=req.getParameter("accident_1");
        String accident_2=req.getParameter("accident_2");
        String accident_3=req.getParameter("accident_3");
        String accident_4=req.getParameter("accident_4");
        String accident_5=req.getParameter("accident_5");
        String providername=req.getParameter("providername");
        String relationship=req.getParameter("relationship");
        String phonename=req.getParameter("phonename");
        String phonenumber=req.getParameter("phonenumber");
        // 获取多选数据
        String[] medicalpay = req.getParameterValues("medicalpay[]");
        String[] financial = req.getParameterValues("financial[]");

// 将数组转换为逗号分隔的字符串
        String medicalpayStr = (medicalpay != null) ? String.join(",", medicalpay) : "";
        String financialStr = (financial != null) ? String.join(",", financial) : "";

// 调用 MyBatis 方法
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        int u = usermapper.informationadd(id, date, reason, name, gender, birthday, number, cordnumber, nation, culture, religion, marrystate, livestate, medicalpayStr, financialStr, disease_1, disease_2, disease_3, accident_1, accident_2, accident_3, accident_4, accident_5, providername, relationship, phonename, phonenumber);

        Writer writer=resp.getWriter();
        sqlSession.commit();
        sqlSession.close();

            // 检查是否存在重复记录
            int count = usermapper.checkDuplicate(id, date, name, gender, number, cordnumber);
            if (count > 0) {
                writer.write("请重新输入");
                sqlSession.close();
                return;

        }
        if(u>0){
            writer.write("添加成功");
        }else writer.write("添加失败");
    }
}
