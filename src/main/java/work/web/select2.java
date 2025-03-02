package work.web;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import work.mapper.UserMapper;
import work.pojo.information;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/select2")
public class select2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
       String phonename = req.getParameter("phonename");
       String phonenumber = req.getParameter("phonenumber");
        PrintWriter writer = resp.getWriter();
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        information i=usermapper.selectinformationbyphone(phonename,phonenumber);
        if (i == null) {
            writer.write("<html><body>");
            writer.write("未找到相关信息...</p>");
            writer.write("<p>1秒后将跳转到查询界面...</p>");
            writer.write("<script type='text/javascript'>");
            writer.write("setTimeout(function() { window.location.href = './select.html'; }, 1000);");
            writer.write("</script>");
            writer.write("</body></html>");
            return;
        }

        // 显示查询结果
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>多条件查询</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            background-color: rgba(220, 220, 220, 0.32);\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            margin: 0;\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "        a {\n" +
                "            display: inline-block;\n" +
                "            width: 330px;\n" +
                "            height: 80px;\n" +
                "            background-color: dodgerblue;\n" +
                "            color: white;\n" +
                "            text-decoration: none;\n" +
                "            text-align: center;\n" +
                "            line-height: 80px;\n" +
                "            font-size: 20px;\n" +
                "            margin: 5px;\n" +
                "            border-radius: 8px;\n" +
                "        }\n" +
                "        a:hover {\n" +
                "            background-color: lightskyblue;\n" +
                "        }\n" +
                "        .select {\n" +
                "            background-color: lightskyblue;\n" +
                "        }\n" +
                "        .search-container {\n" +
                "            position: absolute;\n" +
                "            top: 10px;\n" +
                "            right: 10px;\n" +
                "        }\n" +
                "        .search-container input[type=\"text\"] {\n" +
                "            padding: 8px;\n" +
                "            font-size: 16px;\n" +
                "            border: 1px solid #ccc;\n" +
                "            border-radius: 4px;\n" +
                "        }\n" +
                "        .search-container button {\n" +
                "            padding: 8px;\n" +
                "            font-size: 16px;\n" +
                "            background-color: dodgerblue;\n" +
                "            color: white;\n" +
                "            border: none;\n" +
                "            border-radius: 4px;\n" +
                "            cursor: pointer;\n" +
                "        }\n" +
                "        .search-container button:hover {\n" +
                "            background-color: lightskyblue;\n" +
                "        }\n" +
                "        form {\n" +
                "            max-width: 1000px;\n" +
                "            margin: 0 auto;\n" +
                "            padding: 20px;\n" +
                "            background-color: white;\n" +
                "            border-radius: 10px;\n" +
                "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "        h1, h2, h4 {\n" +
                "            text-align: center;\n" +
                "            color: #333;\n" +
                "        }\n" +
                "        h1 {\n" +
                "            font-size: 28px;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        h2 {\n" +
                "            font-size: 24px;\n" +
                "            margin-top: 30px;\n" +
                "            margin-bottom: 15px;\n" +
                "        }\n" +
                "        h4 {\n" +
                "            font-size: 20px;\n" +
                "            margin-top: 20px;\n" +
                "            margin-bottom: 10px;\n" +
                "        }\n" +
                "        table {\n" +
                "            width: 100%;\n" +
                "            border-collapse: collapse;\n" +
                "            margin: 20px 0;\n" +
                "            background-color: white;\n" +
                "            border-radius: 8px;\n" +
                "            overflow: hidden;\n" +
                "            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "        th, td {\n" +
                "            padding: 15px;\n" +
                "            text-align: left;\n" +
                "            border-bottom: 1px solid #ddd;\n" +
                "        }\n" +
                "        th {\n" +
                "            background-color: #f8f9fa;\n" +
                "            color: #333;\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "        tr:nth-child(even) {\n" +
                "            background-color: #f9f9f9;\n" +
                "        }\n" +
                "        tr:hover {\n" +
                "            background-color: #f1f1f1;\n" +
                "        }\n" +
                "        input[type=\"text\"], input[type=\"radio\"], input[type=\"checkbox\"] {\n" +
                "            margin-right: 10px;\n" +
                "        }\n" +
                "        input[type=\"text\"] {\n" +
                "            padding: 8px;\n" +
                "            border: 1px solid #ccc;\n" +
                "            border-radius: 4px;\n" +
                "            width: 100%;\n" +
                "            max-width: 300px;\n" +
                "        }\n" +
                "        input[type=\"submit\"] {\n" +
                "            padding: 10px 20px;\n" +
                "            background-color: dodgerblue;\n" +
                "            color: white;\n" +
                "            border: none;\n" +
                "            border-radius: 4px;\n" +
                "            cursor: pointer;\n" +
                "            font-size: 16px;\n" +
                "            display: block;\n" +
                "            margin: 20px auto;\n" +
                "        }\n" +
                "        input[type=\"submit\"]:hover {\n" +
                "            background-color: lightskyblue;\n" +
                "        }\n" +
                "        label {\n" +
                "            display: block;\n" +
                "            margin: 5px 0;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"div1\">\n" +
                "    <img src=\"https://www.jkheb2030.org.cn/Content/peixun/img/logo.png\">\n" +
                "</div>\n" +
                "<div class=\"search-container\">\n" +
                "    <input type=\"text\" placeholder=\"搜索...\" name=\"search\" id=\"search\">\n" +
                "    <button type=\"submit\">搜索</button>\n" +
                "</div>\n" +
                "<a href=\"informationadd.html\" >老年人信息导入</a>\n" +
                "<a href=\"assessment1.html\">老年人能力定期评估</a>\n" +
                "<a class=\"select\">能力评估数据多条件查询</a>\n" +
                "<a href=\"ability.html\">能力数据统计</a>\n" +
                "<a href=\"enter.html\">能力数据导出</a>\n" +
                "\n" +
                "<form action=\"/work-demo/informationadd\" method=\"post\">\n" +
                "    <h1>老年人能力评估基本信息表</h1>\n" +
                "    <h2>评估基本信息表</h2>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>评估编号</th>\n" +
                "            <td>"+i.getId()+"</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>评估基准日期</th>\n" +
                "            <td>"+i.getDate()+"</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>评估原因</th>\n" +
                "            <td>\n" + i.getReason()+
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "\n" +
                "    <h2>被评估者的基本信息表</h2>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>姓名</th>\n" +
                "            <td>"+i.getName()+"</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>性别</th>\n" +
                "            <td>\n" +i.getGender()+
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>出生日期</th>\n" +
                "            <td>"+i.getBirthday()+"</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>身份证号</th>\n" +
                "            <td>"+i.getNumber()+"</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>社保卡号</th>\n" +
                "            <td>"+i.getCordnumber()+"</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>民族</th>\n" +
                "            <td>\n" +i.getNation()+
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>文化程度</th>\n" +
                "            <td>\n" +i.getCulture()+
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>宗教信仰</th>\n" +
                "            <td>\n" +i.getReligion()+
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>婚姻状况</th>\n" +
                "            <td>\n" +i.getMarrystate()+
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>居住情况</th>\n" +
                "            <td>\n" +i.getLivestate()+
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>医疗费用支付方式(多选)</th>\n" +
                "            <td>\n" +i.getMedicalpay()+
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>经济来源(多选):</th>\n" +
                "            <td>\n" + i.getFinancial()+
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "\n" +
                "    <h4>疾病诊断</h4>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>痴呆</th>\n" +
                "            <td>\n" + i.getDisease_1()+
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>精神疾病</th>\n" +
                "            <td>\n" +i.getDisease_2()+
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>慢性疾病</th>\n" +i.getDisease_3()+
                "        </tr>\n" +
                "    </table>\n" +
                "\n" +
                "    <h4>近30天内意外事件</h4>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>跌倒</th>\n" +
                "            <td>\n" +i.getAccident_1()+
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>走失</th>\n" +
                "            <td>\n" +i.getAccident_2()+
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>噎食</th>\n" +
                "            <td>\n" +i.getAccident_3()+
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>自杀</th>\n" +
                "            <td>\n" +i.getAccident_4()+
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>其他</th>\n" +
                "            <td>"+ i.getAccident_5()+"</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "\n" +
                "    <h2>信息提供者及联系人信息表</h2>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>信息提供者姓名</th>\n" +
                "            <td>"+i.getProvidername()+"</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>信息提供者与老人的关系</th>\n" +
                "            <td>\n" +i.getRelationship()+
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>联系人姓名</th>\n" +
                "            <td>"+i.getPhonename()+"</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>联系人电话</th>\n" +
                "            <td>"+i.getPhonenumber()+"</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "    <br>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
        sqlSession.commit();
        sqlSession.close();
    }
}