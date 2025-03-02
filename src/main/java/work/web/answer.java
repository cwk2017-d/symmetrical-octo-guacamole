package work.web;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import work.mapper.UserMapper;
import work.pojo.dailystate;
import work.pojo.feelstate;
import work.pojo.mentalstate;
import work.pojo.publicstate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/answer")
public class answer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        String number = req.getParameter("number");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        List<dailystate> d = usermapper.selectdailystate(number);
        List<mentalstate> m = usermapper.selectmentalstate(number);
        List<feelstate> f = usermapper.selectfeelstate(number);
        List<publicstate> p = usermapper.selectpublicstate(number);
        dailystate dd=d.get(0);
        mentalstate mm=m.get(0);
        feelstate ff=f.get(0);
        publicstate pp=p.get(0);
        int yishi=ff.getYishi();
        int shili=ff.getShili();
        int tinli=ff.getTinli();
        int goutong=ff.getGoutong();

        int d1 = dd.getJinshi() + dd.getXizao() + dd.getXiushi() + dd.getChuanyi() + dd.getDabian() + dd.getXiaobian() + dd.getRuce() + dd.getChuangyi() + dd.getZoulu() + dd.getShanglouti();
        int m1 = mm.getRenzhi() + mm.getGongji() + mm.getYiyv();
        int f1 = ff.getYishi() + ff.getShili() + ff.getTinli() + ff.getGoutong();
        int p1 = pp.getShenghuo() + pp.getGongzuo() + pp.getShikong() + pp.getRenwu() + pp.getShejiao();
        int d2=0,m2=0,f2=0,p2=0;
        String d3="能力完好",m3="能力完好",f3="能力完好",p3="能力完好";
        if(d1==100)
        {
            d2=0;
            d3="能力完好";
        }
        if(d1>=65&&d1<=95)
        {
            d2=1;
            d3="轻度受损";
        }
        if(d1>=45&&d1<=60)
        {
            d2=2;
            d3="中度受损";
        }
        if(d1>=0&&d1<=40)
        {
            d2=3;
            d3="重度受损";
        }
        if(m1==0)
        {
            m2=0;
            m3="能力完好";
        }
        if(m1==1)
        {
            m2=1;
            m3="轻度受损";
        }
        if(m1>=2&&m1<=3)
        {
            m2=2;
            m3="中度受损";
        }
        if(m1>=4&&m1<=6)
        {
            m2=3;
            m3="重度受损";
        }
        if(yishi==0&&(shili==0||shili==1)&&(tinli==0||tinli==1)&&goutong==0)
        {
            f2=0;
            f3="能力完好";
        }
        if((yishi==0&&(shili==2||tinli==2))||goutong==1)
        {
            f2=1;
            f3="轻度受损";
        }
        if(((yishi==0&&(shili==3||tinli==3))||goutong==2)||(yishi==1&&(shili>=3||tinli>=3)&&goutong>=2))
        {
            f2=2;
            f3="中度受损 ";
        }
        if((((yishi==0||yishi==1)&&(shili==4||tinli==4))||goutong==3)||yishi==2||yishi==3)
        {
            f2=3;
            f3="重度受损";
        }
        if(p1>=0&&p1<=2)
        {
            p2=0;
            p3="能力完好";
        }
        if(p1>=3&&p1<=7)
        {
            p2=1;
            p3="轻度受损";
        }
        if(p1>=8&&p1<=13)
        {
            p2=2;
            p3="中度受损";
        }
        if(p1>=14&&p1<=20)
        {
            p2=3;
            p3="重度受损";
        }

        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html lang='en'>");
        writer.println("<head>");
        writer.println("    <meta charset='UTF-8'>");
        writer.println("    <title>社会参与评估结果</title>");
        writer.println("<style>");
        writer.println("        table {");
        writer.println("            width: 100%;");
        writer.println("            border-collapse: collapse;");
        writer.println("            margin: 20px 0;");
        writer.println("        }");
        writer.println("        th, td {");
        writer.println("            padding: 12px;");
        writer.println("            text-align: center;");
        writer.println("            border: 1px solid #ddd;");
        writer.println("        }");
        writer.println("        th {");
        writer.println("            background-color: dodgerblue;");
        writer.println("            color: white;");
        writer.println("        }");
        writer.println("        tr:nth-child(even) {");
        writer.println("            background-color: #f2f2f2;");
        writer.println("        }");
        writer.println("        tr:hover {");
        writer.println("            background-color: #ddd;");
        writer.println("        }");
        writer.println("        h2 {");
        writer.println("            color: #333;");
        writer.println("            margin-top: 20px;");
        writer.println("        }"+
               "        body {\n" +
               "            background-color: rgba(220, 220, 220, 0.32);\n" +
               "            font-family: Arial, sans-serif;\n" +
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
               "        .select {\n" +
               "            background-color: lightskyblue;\n" +
               "        }\n" +
               "        .select1{\n" +
               "            background-color: lightskyblue;\n" +
               "        }\n" +
               "        .div2 {\n" +
               "            display: flex;\n" +
               "            justify-content: space-around;\n" +
               "            align-items: center;\n" +
               "            height: 100px;\n" +
               "            background-color: #e1e0e0;\n" +
               "            padding: 0 20px;\n" +
               "        }\n" +
               "        .div2 p {\n" +
               "            font-size: 18px;\n" +
               "            color: #333;\n" +
               "            margin: 0;\n" +
               "            padding: 10px 20px;\n" +
               "            background-color: #f0f0f0;\n" +
               "            border-radius: 8px;\n" +
               "            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n" +
               "        }\n" +
               "        l{\n" +
               "            font-size: 18px;\n" +
               "            color: #5b5a5a;\n" +
               "            margin: 0;\n" +
               "            padding: 10px 20px;\n" +
               "            background-color: lightskyblue;\n" +
               "            border-radius: 8px;\n" +
               "            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n" +
               "        }\n" +
               "        input[type=\"submit\"] {\n" +
               "            padding: 10px 20px;\n" +
               "            background-color: dodgerblue;\n" +
               "            color: white;\n" +
               "            border: none;\n" +
               "            border-radius: 4px;\n" +
               "            cursor: pointer;\n" +
               "            font-size: 16px;\n" +
               "            background-position: center bottom;\n" +
               "        }\n" +
               "        input[type=\"submit\"]:hover {\n" +
               "            background-color: lightskyblue;\n" +
               "        }\n" +
               "    </style>\n" +
               "</head>\n" +
               "<body>\n" +
               "<div class=\"div1\">\n" +
               "    <img src=\"https://www.jkheb2030.org.cn/Content/peixun/img/logo.png\" >\n" +
               "</div>\n" +
               "<div class=\"search-container\">\n" +
               "    <input type=\"text\" placeholder=\"搜索...\" name=\"search\" id=\"search\">\n" +
               "    <button type=\"submit\">搜索</button>\n" +
               "</div>\n" +
               "<a href=\"informationadd.html\">老年人信息导入</a>\n" +
               "<a class=\"select\">老年人能力定期评估</a>\n" +
               "<a href=\"select1.html\">能力评估数据多条件查询</a>\n" +
               "<a href=\"ability.html\">能力数据统计</a>\n" +
               "<a href=\"enter.html\">能力数据导出</a>\n" +
               "<div class=\"div2\">\n" +
               "    <l>日常生活活动评估</l>\n" +
               "    <l>精神状态评估</l>\n" +
               "    <l>感知觉与沟通评估</l>\n" +
               "    <l>社会参与评估</l>\n" +
               "</div>");
        writer.println("<h2>查询结果:</h2>");
        writer.println("<table>");
        writer.println("    <tr><th>进食</th><th>洗澡</th><th>修饰</th><th>穿衣</th><th>大便控制</th><th>小便控制</th><th>如厕</th><th>床椅转移</th><th>平地行走</th><th>上下楼梯</th><th>日常生活活动总分</th>分级<th></th><th>分级名称</th></tr>");
        writer.println("    <tr>");
        writer.println("        <td>" + dd.getJinshi() + "</td>");
        writer.println("        <td>" + dd.getXizao() + "</td>");
        writer.println("        <td>" + dd.getXiushi() + "</td>");
        writer.println("        <td>" + dd.getChuanyi() + "</td>");
        writer.println("        <td>" + dd.getDabian() + "</td>");
        writer.println("        <td>" + dd.getXiaobian() + "</td>");
        writer.println("        <td>" + dd.getRuce() + "</td>");
        writer.println("        <td>" + dd.getChuangyi() + "</td>");
        writer.println("        <td>" + dd.getZoulu() + "</td>");
        writer.println("        <td>" + dd.getShanglouti() + "</td>");
        writer.println("        <td>" + d1 + "</td>");
        writer.println("        <td>" + d2 + "</td>");
        writer.println("        <td>" + d3 + "</td>");
        writer.println("    </tr>");
        writer.println("</table>");
        writer.println("<table>");
        writer.println("    <tr><th>认知功能</th><th>攻击行为</th><th>抑郁症状</th><th>精神状态分级</th><th>分级</th><th>分级名称</th></tr>");
        writer.println("    <tr>");
        writer.println("        <td>" + mm.getRenzhi() + "</td>");
        writer.println("        <td>" + mm.getGongji() + "</td>");
        writer.println("        <td>" + mm.getYiyv() + "</td>");
        writer.println("        <td>" + m1 + "</td>");
        writer.println("        <td>" + m2 + "</td>");
        writer.println("        <td>" + m3 + "</td>");
        writer.println("    </tr>");
        writer.println("</table>");
        writer.println("<table>");
        writer.println("    <tr><th>意识水平</th><th>视力</th><th>听力</th><th>沟通交流</th><th>分级</th><th>分级名称</th></tr>");
        writer.println("    <tr>");
        writer.println("        <td>" + ff.getYishi() + "</td>");
        writer.println("        <td>" + ff.getShili() + "</td>");
        writer.println("        <td>" + ff.getTinli() + "</td>");
        writer.println("        <td>" + ff.getGoutong() + "</td>");
        writer.println("        <td>" + f2 + "</td>");
        writer.println("        <td>" + f3 + "</td>");
        writer.println("    </tr>");
        writer.println("</table>");
        writer.println("<table>");
        writer.println("    <tr><th>生活能力</th><th>工作能力</th><th>时间/空间定向</th><th>人物定向</th><th>社会交往能力</th><th>社会参与总分</th><th>分级</th><th>分级名称</th></tr>");
        writer.println("    <tr>");
        writer.println("        <td>" + pp.getShenghuo() + "</td>");
        writer.println("        <td>" + pp.getGongzuo() + "</td>");
        writer.println("        <td>" + pp.getShikong() + "</td>");
        writer.println("        <td>" + pp.getRenwu() + "</td>");
        writer.println("        <td>" + pp.getShejiao() + "</td>");
        writer.println("        <td>" + p1 + "</td>");
        writer.println("        <td>" + p2 + "</td>");
        writer.println("        <td>" + p3 + "</td>");
        writer.println("    </tr>");
        writer.println("</table>");
        writer.println("</body>");
        writer.println("</html>");

        sqlSession.commit();
        sqlSession.close();
    }
}