package com.example.group11officedeskbooking.DTO;

public class BookingDTO {

    private int booking_id;
    private String booking_date;
    private int User_user_id;
    private int Desk_desk_id;

    public BookingDTO(int booking_id, String booking_date, int user_user_id, int desk_desk_id) {
        this.booking_id = booking_id;
        this.booking_date = booking_date;
        User_user_id = user_user_id;
        Desk_desk_id = desk_desk_id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public int getUser_user_id() {
        return User_user_id;
    }

    public int getDesk_desk_id() {
        return Desk_desk_id;
    }
}
