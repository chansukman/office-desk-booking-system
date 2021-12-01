package com.example.group11officedeskbooking.model;

import com.example.group11officedeskbooking.DTO.BookingDTO;
import com.example.group11officedeskbooking.DTO.DeskDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BookingDTO(rs.getString("booking_date"),
                rs.getInt("desk_number"),
                rs.getString("desk_location"));
    }

}
