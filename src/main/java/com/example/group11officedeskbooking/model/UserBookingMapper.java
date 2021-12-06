package com.example.group11officedeskbooking.model;

import com.example.group11officedeskbooking.DTO.UserBookingDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBookingMapper implements RowMapper {
/*Mapping a specific columns from adms database tables
    (Booking.booking_id, Booking.booking_date, Booking.Desk_desk_id and location.city */

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserBookingDTO(rs.getInt("booking_id"),
                rs.getString("Desk.desk_location"),
                rs.getString("formattedDate"),
                rs.getInt("Desk_desk_id"));
    }
}
