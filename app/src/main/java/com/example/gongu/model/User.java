package com.example.gongu.model;

public class User {
    private int userid;
    private String name;
    private String email;
    private String password;
    private String selectedteam;
    private String account;
    public User(int userid, String name, String email, String password, String selectedteam, String account) {
        super();
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.selectedteam = selectedteam;
        this.account = account;
    }
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSelectedteam() {
        return selectedteam;
    }
    public void setSelectedteam(String selectedteam) {
        this.selectedteam = selectedteam;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }


}
