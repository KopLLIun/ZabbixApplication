package com.zabbix.zabbixapplication.model;

public class User {

    private String login;
    private String password;
    private String auth;

    public User() {

    }

    public User(String login, String password, String auth) {
        this.login = login;
        this.password = password;
        this.auth = auth;
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

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
