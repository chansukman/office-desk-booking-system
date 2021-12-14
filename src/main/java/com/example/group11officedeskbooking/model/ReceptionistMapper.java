package com.example.group11officedeskbooking.model;

import com.example.group11officedeskbooking.DTO.ReceptionistTask;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceptionistMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("booking_id");
        int userID =rs.getInt("User_user_id");
        String firstName = rs.getString("User.first_name");
        String lastName = rs.getString("User.last_name");
        String deskLocation =rs.getString("desk_location");
        int deskNumber = rs.getInt("Desk.desk_number");
        String date =rs.getString("today");
        boolean isAttend = rs.getBoolean("isattend");
        ReceptionistTask receptionistTask = new ReceptionistTask(id, userID, firstName,lastName,deskLocation,deskNumber, date);
        return receptionistTask;
    }
}
