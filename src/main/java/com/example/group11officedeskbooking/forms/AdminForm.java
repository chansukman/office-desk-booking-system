package com.example.group11officedeskbooking.forms;

public class AdminForm {
    String username;
    String password;

    public AdminForm(String username, String password){
        super();
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
