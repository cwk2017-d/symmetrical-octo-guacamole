package work.pojo;

public class publicstate {
    private String number;
    private int shenghuo;
    private int gongzuo;
    private int shikong;
    private int renwu;
    private int shejiao;

    @Override
    public String toString() {
        return "publicstate{" +
                "number='" + number + '\'' +
                ", shenghuo=" + shenghuo +
                ", hongzuo=" + gongzuo +
                ", shikong=" + shikong +
                ", renwu=" + renwu +
                ", shejiao=" + shejiao +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getShenghuo() {
        return shenghuo;
    }

    public void setShenghuo(int shenghuo) {
        this.shenghuo = shenghuo;
    }

    public int getShikong() {
        return shikong;
    }

    public void setShikong(int shikong) {
        this.shikong = shikong;
    }

    public int getGongzuo() {
        return gongzuo;
    }

    public void setGongzuo(int gongzuo) {
        this.gongzuo = gongzuo;
    }

    public int getRenwu() {
        return renwu;
    }

    public void setRenwu(int renwu) {
        this.renwu = renwu;
    }

    public int getShejiao() {
        return shejiao;
    }

    public void setShejiao(int shejiao) {
        this.shejiao = shejiao;
    }
}
