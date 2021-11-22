package com.example.group11officedeskbooking.forms;

public class UserForm {
    String id;
    String username;
    String password;


    public UserForm(String id,String username, String password){
        super();
        this.id=id;
        this.username=username;
        this.password=password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
