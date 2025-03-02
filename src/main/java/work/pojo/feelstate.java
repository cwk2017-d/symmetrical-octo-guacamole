package work.pojo;

public class feelstate {
    private String number;
    private int yishi;
    private int shili;
    private int tinli;
    private int goutong;

    @Override
    public String toString() {
        return "feelstate{" +
                "number='" + number + '\'' +
                ", yishi=" + yishi +
                ", shili=" + shili +
                ", tinli=" + tinli +
                ", goutong=" + goutong +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYishi() {
        return yishi;
    }

    public void setYishi(int yishi) {
        this.yishi = yishi;
    }

    public int getShili() {
        return shili;
    }

    public void setShili(int shili) {
        this.shili = shili;
    }

    public int getTinli() {
        return tinli;
    }

    public void setTinli(int tinli) {
        this.tinli = tinli;
    }

    public int getGoutong() {
        return goutong;
    }

    public void setGoutong(int goutong) {
        this.goutong = goutong;
    }
}
