package com.example.group11officedeskbooking.DTO;

public class AdminDTO {
    String firstname;
    String password;

    public AdminDTO( String firstname, String password) {
        this.firstname = firstname;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
