package work.web;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import work.mapper.UserMapper;
import work.pojo.ability;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/enter")
public class enter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        String number=req.getParameter("number");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        ability a=usermapper.selectability(number);
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>能力数据导出</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            background-color: rgba(220, 220, 220, 0.32);\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            margin: 0;\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "        a {\n" +
                "            display: inline-block;\n" +
                "            width: 300px;\n" +
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
                "        h1, h2 {\n" +
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
                "\n" +
                "\n" +
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
                "\n" +
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
                "<a  href=\"informationadd.html\">老年人信息导入</a>\n" +
                "<a href=\"assessment1.html\">老年人能力定期评估</a>\n" +
                "<a href=\"select1.html\">能力评估数据多条件查询</a>\n" +
                "<a href=\"ability.html\">能力数据统计</a>\n" +
                "<a class=\"select\">能力数据导出</a>\n" +
                "\n" +
                "<form action=\"/work-demo/abilityadd\" method=\"post\">\n" +
                "    <h1>能力数据统计</h1>\n" +
                "    <h2>老年人能力评估报告</h2>\n" +
                "    <table>\n" +
                "        <h3>一级指标分级</h3>\n" +
                "\n" +
                "        <tr>\n" +
                "            <th>日常生活活动</th>\n" +
                "            <td>"+a.getDaily()+"</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>精神状态</th>\n" +
                "            <td>"+a.getMental()+"</td>\n" +
                "        </tr>\n" +
                "        <th>感知觉与沟通</th>\n" +
                "        <td>"+a.getFeel()+"</td>\n" +
                "        </tr>\n" +
                "        <th>社会参与</th>\n" +
                "        <td>"+a.getPublics()+"</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "    <h3>老年人能力初步等级</h3>\n" +
                "    <h4>0 能力完好：</h4>\n" +
                "    <p>日常生活活动、精神状态、感知觉与沟通分级均为 0，社会参与分级为 0 或 1</p>\n" +
                "    <h4>1 轻度失能：</h4>\n" +
                "    <p>日常生活活动分级为 0，但精神状态、感知觉与沟通中至少一项分级为 1 及以上，或社会参与的分级为 2；</p>\n" +
                "    <p>或日常生活活动分级为 1，精神状态、感知觉与沟通、社会参与中至少有一项的分级为 0 或 1 </p>\n" +
                "    <h4>2 中度失能：</h4>\n" +
                "    <p>日常生活活动分级为 1，但精神状态、感知觉与沟通、社会参与均为 2，或有一项为 3； </p>\n" +
                "    <p>或日常生活活动分级为 2，且精神状态、感知觉与沟通、社会参与中有 1-2 项的分级为 1 或 2</p>\n" +
                "    <h4>3 重度失能：</h4>\n" +
                "    <p>日常生活活动的分级为 3；</p>\n" +
                "    <p>或日常生活活动、精神状态、感知觉与沟通、社会参与分级均为 2；</p>\n" +
                "    <p>或日常生活活动分级为 2，且精神状态、感知觉与沟通、社会参与中至少有一项分级为 3 </p>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>0 能力完好   1 轻度失能   2 中度失能   3 重度失能</th>\n" +
                "            <td>"+a.getAbility1()+"</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "    <h3>等级变更条款</h3>\n" +
                "    <p>0 无以下情况</p>\n" +
                "    <p>1 有认知障碍/痴呆、精神疾病者，在原有能力级别上提高一个等级； </p>\n" +
                "    <p>2 近 30 天内发生过 2 次及以上跌倒、噎食、自杀、走失者，在原有能力级别上提高一个等级； </p>\n" +
                "    <p>3 处于昏迷状态者，直接评定为重度失能；</p>\n" +
                "    <p>4 若初步等级确定为“3 重度失能”，则不考虑上述 1-3 中各情况对最终等级的影响，等级不再提高 </p>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>请输入等级变更情况</th>\n" +
                "            <td>"+a.getChanging()+"</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "    <h3>老年人能力最终等级</h3>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>0 能力完好 1 轻度失能 2 中度失能 3 重度失能 </th>\n" +
                "            <td>"+a.getAbility2()+"</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>评估员1签名:</th>\n" +
                "            <td>"+a.getAuditor1()+"</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>评估员2签名:</th>\n" +
                "            <td>"+a.getAuditor2()+"</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>信息提供者签名:</th>\n" +
                "            <td>"+a.getProvider()+"</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <th>日期:</th>\n" +
                "            <td>"+a.getDate()+"</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "    <br>\n" +
                "\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
        sqlSession.commit();
        sqlSession.close();
    }
}
