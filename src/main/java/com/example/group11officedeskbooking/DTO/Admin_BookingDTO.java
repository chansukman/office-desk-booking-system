package com.example.group11officedeskbooking.DTO;

import com.example.group11officedeskbooking.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
@RequiredArgsConstructor
public class Admin_BookingDTO {

    private int booking_id;
    private String booking_date;
    private int User_user_id;
    private int desk_number;
    private String first_name;
    private String last_name;
    private String desk_location;
    private String user_name;

    public Admin_BookingDTO(int booking_id, String booking_date, int User_user_id, int desk_number, String first_name, String last_name, String desk_location){
        this.booking_id = booking_id;
        this.booking_date = booking_date;
        this.User_user_id = User_user_id;
        this.desk_number = desk_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.desk_location = desk_location;
        this.user_name = this.first_name + " " + this.last_name;
    }

    public int getUser_user_id() {
        return User_user_id;
    }

    public void setUser_user_id(int user_user_id) {
        this.User_user_id = user_user_id;
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

    public int getDesk_number() {
        return desk_number;
    }

    public void setDesk_number(int desk_number) {
        this.desk_number = desk_number;
    }

    public String getFirst_name() {return first_name;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public String getLast_name() {return last_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

    public String getDesk_location() {return desk_location;}

    public void setDesk_location(String desk_location) {this.desk_location = desk_location;}

    public String getUser_name() {return user_name;}
}
