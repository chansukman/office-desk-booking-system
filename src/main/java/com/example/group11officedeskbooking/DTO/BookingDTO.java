package com.example.group11officedeskbooking.DTO;

public class BookingDTO {

    private String booking_date;
    private int desk_number;
    private String desk_location;

    public BookingDTO(String booking_date, int desk_number, String desk_location) {
        this.booking_date = booking_date;
        this.desk_number = desk_number;
        this.desk_location = desk_location;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public int getDesk_number() {
        return desk_number;
    }

    public String getDesk_location() {
        return desk_location;
    }
}
