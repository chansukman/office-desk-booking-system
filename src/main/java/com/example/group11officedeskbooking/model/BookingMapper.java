package com.example.group11officedeskbooking.model;

import com.example.group11officedeskbooking.DTO.BookingDTO;
import com.example.group11officedeskbooking.DTO.DeskDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BookingDTO(rs.getInt("booking_id"),
                rs.getString("booking_date"),
                rs.getInt("User_user_id"),
                rs.getInt("Desk_desk_id"));
    }

}
