package com.example.group11officedeskbooking.model;


import com.example.group11officedeskbooking.DTO.Admin_BookingDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin_BookingMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Admin_BookingDTO(rs.getInt("booking_id"),
                rs.getDate("booking_date"),
                rs.getDate("booking_time"),
                rs.getInt("User_user_id"),
                rs.getInt("Desk_desk_id"),
                rs.getTimestamp("transaction_timestamp"));
    }
}
