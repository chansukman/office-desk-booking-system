package com.example.group11officedeskbooking.DTO;

public class AdminDTO {
    Integer admin_id;
    String first_name;
    String password;

    public AdminDTO(Integer admin_id,String first_name, String password) {
        this.admin_id=admin_id;
        this.first_name = first_name;
        this.password = password;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
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
