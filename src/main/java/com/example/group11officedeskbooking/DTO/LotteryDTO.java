package com.example.group11officedeskbooking.DTO;

public class LotteryDTO {

    private String date;
    private String location;
    private int numUsers;
    private int user_id;

    public LotteryDTO(String date, String location, int user_id) {
        this.date = date;
        this.location = location;
        this.user_id = user_id;
    }

    public LotteryDTO(String date, String location) {
        this.date = date;
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public int getNumUsers() {
        return numUsers;
    }

    public void setNumUsers(int numUsers){
        this.numUsers = numUsers;
    }

    public int getUser_id() {
        return user_id;
    }
}
