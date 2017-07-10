package entity;

import entity.Otziv;

import java.util.List;

public class User {
    private String name;
    private int age;
    private String login;
    private String password;
private int login4ik;

    private List<Otziv> otzivs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Otziv> getOtzivs() {
        return otzivs;
    }

    public void setOtzivs(List<Otziv> otzivs) {
        this.otzivs = otzivs;
    }


}
