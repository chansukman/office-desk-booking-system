package com.example.group11officedeskbooking.model;

import com.example.group11officedeskbooking.DTO.BookingDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AllBookingsMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new BookingDTO(rs.getString("booking_date"),
                rs.getInt("desk_number"),
                rs.getString("desk_location"),
                rs.getString("first_name"),
                rs.getString("last_name"));
    }
}
