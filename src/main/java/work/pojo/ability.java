package work.pojo;

public class ability {
    private String number;
    private String daily;
    private String mental;
    private String feel;
    private String publics;
    private String ability1;
    private String changing;
    private String ability2;
    private String auditor1;
    private String auditor2;
    private String provider;
    private String date;

    @Override
    public String toString() {
        return "ability{" +
                "number='" + number + '\'' +
                ", daily='" + daily + '\'' +
                ", mental='" + mental + '\'' +
                ", feel='" + feel + '\'' +
                ", publics='" + publics + '\'' +
                ", ability1='" + ability1 + '\'' +
                ", changing='" + changing + '\'' +
                ", ability2='" + ability2 + '\'' +
                ", auditor1='" + auditor1 + '\'' +
                ", auditor2='" + auditor2 + '\'' +
                ", provider='" + provider + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public String getMental() {
        return mental;
    }

    public void setMental(String mental) {
        this.mental = mental;
    }

    public String getFeel() {
        return feel;
    }

    public void setFeel(String feel) {
        this.feel = feel;
    }

    public String getAbility1() {
        return ability1;
    }

    public void setAbility1(String ability1) {
        this.ability1 = ability1;
    }

    public String getPublics() {
        return publics;
    }

    public void setPublics(String publics) {
        this.publics = publics;
    }

    public String getChanging() {
        return changing;
    }

    public void setChanging(String changing) {
        this.changing = changing;
    }

    public String getAbility2() {
        return ability2;
    }

    public void setAbility2(String ability2) {
        this.ability2 = ability2;
    }

    public String getAuditor1() {
        return auditor1;
    }

    public void setAuditor1(String auditor1) {
        this.auditor1 = auditor1;
    }

    public String getAuditor2() {
        return auditor2;
    }

    public void setAuditor2(String auditor2) {
        this.auditor2 = auditor2;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
