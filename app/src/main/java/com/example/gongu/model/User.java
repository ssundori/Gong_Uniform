package com.example.gongu.model;

public class User {
    private int userid;
    private String name;
    private String email;
    private String password;
    private String selectedteam;
    private String account;

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
