package com.example.group11officedeskbooking.DTO;

public class UserDTO {
    Integer user_id;
     String first_name;
    String last_name;
    String email;
     String department;
    String password;

    public UserDTO(Integer user_id, String first_name, String last_name, String email, String department, String password) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.department = department;
        this.password = password;
    }

    public UserDTO(Integer user_id, String first_name, String password) {
        this.user_id=user_id;
        this.first_name = first_name;
        this.password = password;

    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getFirstNameLastNameUserId(){
        return first_name + " " + last_name + ", " + user_id;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
