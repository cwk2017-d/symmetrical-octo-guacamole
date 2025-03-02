package work.pojo;

public class mentalstate {
    private String number;
    private int renzhi;
    private int gongji;
    private int yiyv;

    @Override
    public String toString() {
        return "mentalstate{" +
                "number='" + number + '\'' +
                ", renzhi=" + renzhi +
                ", gongji=" + gongji +
                ", yiyv=" + yiyv +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getRenzhi() {
        return renzhi;
    }

    public void setRenzhi(int renzhi) {
        this.renzhi = renzhi;
    }

    public int getGongji() {
        return gongji;
    }

    public void setGongji(int gongji) {
        this.gongji = gongji;
    }

    public int getYiyv() {
        return yiyv;
    }

    public void setYiyv(int yiyv) {
        this.yiyv = yiyv;
    }
}
