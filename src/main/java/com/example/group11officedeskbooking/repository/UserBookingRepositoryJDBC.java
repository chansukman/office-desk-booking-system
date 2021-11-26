package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.UserBookingDTO;
import com.example.group11officedeskbooking.model.UserBookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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
                "SELECT booking_id,booking_date,Booking.Desk_desk_id,city FROM Booking\n" +
                        "INNER JOIN Desk\n" +
                        "\tON Booking.Desk_desk_id = Desk.desk_id\n" +
                        "INNER JOIN location\n" +
                        "\tON DESK.desk_location = location.location_id\n" +
                        "WHERE Booking.User_user_id=?\n" +
                        "ORDER BY booking_id ASC\n", new UserBookingMapper(), new Object[]{id});

    }
}
