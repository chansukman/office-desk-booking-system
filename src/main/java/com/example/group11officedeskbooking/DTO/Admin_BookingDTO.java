package com.example.group11officedeskbooking.DTO;

import java.util.Date;

public class Admin_BookingDTO {

    private int booking_id;
    private String booking_name;
    private String booking_date;
    private String booking_time;
    private int User_user_id;
    private int Desk_desk_id;
    private Date transaction_timestamp;

    public Admin_BookingDTO(int booking_id, String booking_name, String booking_date, String booking_time, int User_user_id, int Desk_desk_id, Date transaction_timestamp){
        this.booking_id = booking_id;
        this.booking_date = booking_date;
        this.booking_name = booking_name;
        this.booking_time = booking_time;
        this.User_user_id = User_user_id;
        this.Desk_desk_id = Desk_desk_id;
        this.transaction_timestamp = transaction_timestamp;
    }

    public int getUser_user_id() {
        return User_user_id;
    }

    public void setUser_user_id(int user_user_id) {
        User_user_id = user_user_id;
    }

    public String getBooking_name() {
        return booking_name;
    }

    public void setBooking_name(String booking_name) {
        this.booking_name = booking_name;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    public String getBooking_time() {
        return booking_time;
    }

    public void setBooking_time(String booking_time) {
        this.booking_time = booking_time;
    }

    public int getDesk_desk_id() {
        return Desk_desk_id;
    }

    public void setDesk_desk_id(int desk_desk_id) {
        Desk_desk_id = desk_desk_id;
    }

    public Date getTransaction_timestamp() {
        return transaction_timestamp;
    }

    public void setTransaction_timestamp(Date transaction_timestamp) {
        this.transaction_timestamp = transaction_timestamp;
    }

}
