package com.example.group11officedeskbooking.DTO;

public class UserDTO {
    String firstname;
    String password;

    public UserDTO( String firstname, String password) {
        this.firstname = firstname;
        this.password = password;
    }

    public String getUsername() {
        return firstname;
    }

    public void setUsername(String username) {
        this.firstname = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
