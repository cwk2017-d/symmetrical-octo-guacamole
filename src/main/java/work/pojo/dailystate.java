package work.pojo;

public class dailystate {
  private String number;
  private int jinshi;
  private int xizao;
  private int xiushi;
    private int chuanyi;
    private int dabian;
    private int xiaobian;
    private int ruce;
    private int chuangyi;
    private int zoulu;
    private int shanglouti;

    @Override
    public String toString() {
        return "dailystate{" +
                "number='" + number + '\'' +
                ", jinshi=" + jinshi +
                ", xizao=" + xizao +
                ", xiushi=" + xiushi +
                ", chuanyi=" + chuanyi +
                ", dabian=" + dabian +
                ", xiaobian=" + xiaobian +
                ", ruce=" + ruce +
                ", chuangyi=" + chuangyi +
                ", zoulu=" + zoulu +
                ", shanglouti=" + shanglouti +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getJinshi() {
        return jinshi;
    }

    public void setJinshi(int jinshi) {
        this.jinshi = jinshi;
    }

    public int getXizao() {
        return xizao;
    }

    public void setXizao(int xizao) {
        this.xizao = xizao;
    }

    public int getXiushi() {
        return xiushi;
    }

    public void setXiushi(int xiushi) {
        this.xiushi = xiushi;
    }

    public int getChuanyi() {
        return chuanyi;
    }

    public void setChuanyi(int chuanyi) {
        this.chuanyi = chuanyi;
    }

    public int getDabian() {
        return dabian;
    }

    public void setDabian(int dabian) {
        this.dabian = dabian;
    }

    public int getXiaobian() {
        return xiaobian;
    }

    public void setXiaobian(int xiaobian) {
        this.xiaobian = xiaobian;
    }

    public int getRuce() {
        return ruce;
    }

    public void setRuce(int ruce) {
        this.ruce = ruce;
    }

    public int getChuangyi() {
        return chuangyi;
    }

    public void setChuangyi(int chuangyi) {
        this.chuangyi = chuangyi;
    }

    public int getZoulu() {
        return zoulu;
    }

    public void setZoulu(int zoulu) {
        this.zoulu = zoulu;
    }

    public int getShanglouti() {
        return shanglouti;
    }

    public void setShanglouti(int shanglouti) {
        this.shanglouti = shanglouti;
    }
}
