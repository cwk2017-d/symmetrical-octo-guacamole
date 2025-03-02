package work.pojo;

public class login {
    private String number;
    private String password;

    @Override
    public String toString() {
        return "login{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
