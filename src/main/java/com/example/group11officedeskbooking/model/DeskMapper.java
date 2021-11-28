package com.example.group11officedeskbooking.model;

import com.example.group11officedeskbooking.DTO.DeskDTO;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeskMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new DeskDTO(rs.getInt("desk_id"),
                rs.getInt("desk_number"),
                rs.getBoolean("has_monitors"),
                rs.getString("desk_type"),
                rs.getString("desk_location"));
    }
}
