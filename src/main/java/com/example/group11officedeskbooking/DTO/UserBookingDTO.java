package com.example.group11officedeskbooking.DTO;

public class UserBookingDTO {
    private int id;
    private String date;
    private String city;
    private int deskID;


    public UserBookingDTO(int id,String date, String city, int deskID) {
        this.id = id;
        this.date = date;
        this.city = city;
        this.deskID = deskID;

    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getDate() {return date;}

    public String getCity() {return city;}

    public int getDeskID() {return deskID;}
}
