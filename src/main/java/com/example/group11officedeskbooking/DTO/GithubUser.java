package com.example.group11officedeskbooking.DTO;

public class GithubUser {
    private Integer id;
    private String login;

    public GithubUser(Integer id, String login) {
        this.id = id;
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
