package com.example.group11officedeskbooking.model;

import com.example.group11officedeskbooking.DTO.LotteryDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LotteryMapperUserId implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LotteryDTO(rs.getString("date"),
                rs.getInt("user_id"),
                rs.getString("location")
        );
    }
}
