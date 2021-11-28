package com.example.group11officedeskbooking.model;

import com.example.group11officedeskbooking.DTO.MapDTO;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new MapDTO(rs.getInt("map_id"),
                rs.getString("location"),
                rs.getString("image"));
    }

}
