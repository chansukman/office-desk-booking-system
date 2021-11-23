package com.example.group11officedeskbooking.DTO;

public class AdminDTO {
    String first_name;
    String password;

    public AdminDTO(String first_name, String password) {

        this.first_name = first_name;
        this.password = password;
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
