package work.mapper;

import org.apache.ibatis.annotations.Param;
import work.pojo.*;

import java.util.List;

public interface UserMapper {
    int addlogin(@Param("number") String number, @Param("password") String password);
    login selectlogin(@Param("number") String number, @Param("password") String password);
    int informationadd(@Param("id") String id,@Param("date") String date,@Param("reason") String reason,@Param("name") String name,@Param("gender") String gender,@Param("birthday") String birthday,@Param("number") String number,@Param("cordnumber") String cordnumber,@Param("nation") String nation,@Param("culture") String culture,@Param("religion") String religion,@Param("marrystate") String marrystate,@Param("livestate") String livestate,@Param("medicalpay") String medicalpay,@Param("financial") String financial,@Param("disease_1") String disease_1,@Param("disease_2") String disease_2,@Param("disease_3") String disease_3,@Param("accident_1") String accident_1,@Param("accident_2") String accident_2,@Param("accident_3") String accident_3,@Param("accident_4") String accident_4,@Param("accident_5") String accident_5,@Param("providername") String providername,@Param("relationship") String relationship,@Param("phonename") String phonename,@Param("phonenumber") String phonenumber);
    int assessment1add(@Param("number") String number,@Param("jinshi") int jinshi,@Param("xizao") int xizao,@Param("xiushi") int xiushi,@Param("chuanyi") int chuanyi,@Param("dabian") int dabian,@Param("xiaobian") int xiaobian,@Param("ruce") int ruce,@Param("chuangyi") int chuangyi,@Param("zoulu") int zoulu,@Param("shanglouti") int shanglouti);
    int assessment2add(@Param("number") String number,@Param("renzhi") int renzhi,@Param("gongji") int gongji,@Param("yiyv") int yiyv);
    int assessment3add(@Param("number") String number,@Param("yishi") int yishi,@Param("shili") int shili,@Param("tinli") int tinli,@Param("goutong") int goutong);
    int assessment4add(@Param("number") String number,@Param("shenghuo") int shenghuo,@Param("gongzuo") int gongzuo,@Param("shikong") int shikong,@Param("renwu") int renwu,@Param("shejiao") int shejiao);
    List<dailystate> selectdailystate(@Param("number") String number);
    List<mentalstate> selectmentalstate(@Param("number") String number);
    List<feelstate> selectfeelstate(@Param("number") String number);
    List<publicstate> selectpublicstate(@Param("number") String number);
    information selectinformationbynumber(@Param("number") String number);
    information selectinformationbyphone(@Param("phonename") String phonename,@Param("phonenumber") String phonenumber);
    information selectinformation(@Param("number") String number,@Param("phonenumber") String phonenumber);
        int checkDuplicate(String id, String date, String name, String gender, String number, String cordnumber);
    int abilityadd(@Param("number") String number,@Param("daily") String daily,@Param("mental") String mental,@Param("feel") String feel,@Param("publics") String publics,@Param("ability1") String ability1,@Param("changing") String changing,@Param("ability2") String ability2,@Param("auditor1") String auditor1,@Param("auditor2") String auditor2,@Param("provider") String provider,@Param("date") String date);
    ability selectability(@Param("number") String number);
}
