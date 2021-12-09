package com.example.group11officedeskbooking.model;

import com.example.group11officedeskbooking.DTO.DeskDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new String(rs.getString("desk_location"));
    }
}
