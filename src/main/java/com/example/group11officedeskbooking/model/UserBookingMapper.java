package com.example.group11officedeskbooking.model;

import com.example.group11officedeskbooking.DTO.UserBookingDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBookingMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserBookingDTO(rs.getInt("booking_id"),
                rs.getString("city"),
                rs.getString("booking_date"),
                rs.getInt("Desk_desk_id"));
    }
}
