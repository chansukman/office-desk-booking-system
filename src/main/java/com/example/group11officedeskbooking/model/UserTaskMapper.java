package com.example.group11officedeskbooking.model;

import com.example.group11officedeskbooking.DTO.UserTask;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTaskMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("booking_id");
        String date = rs.getString("booking_date");
        int deskId = rs.getInt("Desk_desk_id");
        int userId = rs.getInt("User_user_id");
        UserTask userTask = new UserTask(id, date, deskId, userId);
        return userTask;
    }
}
