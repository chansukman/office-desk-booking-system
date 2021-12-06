package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.BookingDTO;
import com.example.group11officedeskbooking.DTO.UserBookingDTO;
import com.example.group11officedeskbooking.model.BookingMapper;
import com.example.group11officedeskbooking.model.UserBookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserBookingRepositoryJDBC implements UserBookingRepository{
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public UserBookingRepositoryJDBC(JdbcTemplate aTemplate){
        jdbcTemplate = aTemplate;
    }

    @Override
    //list DTO for all User booking records
    public List<UserBookingDTO> findBookingByUserId(int id) {

        // JdbcTemplate query used to get multiple records from the database

        return jdbcTemplate.query(
            "SELECT booking_id,booking_date,desk_location,Desk_desk_id, DATE_FORMAT(booking_date,'%D %M %Y') AS formattedDate FROM Booking JOIN Desk ON Booking.Desk_desk_id = Desk.desk_id WHERE Booking.User_user_id=? && Booking_date >= now()",

                new UserBookingMapper(), new Object[]{id});

    }

    @Override
    public boolean addBooking(int user_id, String date, int desk_id){
        int rows = jdbcTemplate.update(
                "insert into booking(booking_date, User_user_id, Desk_desk_id) values(?,?,?)",
                new Object[]{date, user_id, desk_id});
        return rows>0;
    }

    @Override
    public BookingDTO getUniqueBooking(String date, int desk_id){
        return (BookingDTO) jdbcTemplate.queryForObject(
                "SELECT Booking.booking_date, Desk.desk_number, Desk.desk_location from Booking Inner Join Desk ON Booking.Desk_desk_id = Desk.desk_id where booking_date=? and Desk_desk_id=?",
                new BookingMapper(),
                new Object[]{date, desk_id});
    }

}
