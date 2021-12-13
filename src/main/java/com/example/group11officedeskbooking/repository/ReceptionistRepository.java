package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.ReceptionistTask;
import com.example.group11officedeskbooking.DTO.UserTaskDAO;
import com.example.group11officedeskbooking.model.ReceptionistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReceptionistRepository implements UserTaskDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Override
    public int updateCancelTable(int id) {
        return 0;
    }

    @Override
    public int deleteBooking(int id) {
        return 0;
    }

    @Override
    public List<ReceptionistTask> getDailyBooking(String deskLocation) {
        return  jdbcTemplate.query(
                "SELECT booking_id,User_user_id,User.first_name, User.last_name, desk_location,Desk.desk_number,curdate()AS today  FROM Booking " +
                        "JOIN Desk ON Booking.Desk_desk_id = Desk.desk_id " +
                        "JOIN User ON Booking.User_user_id = User.user_id " +
                        "WHERE  Booking_date = CURDATE()&& desk_location=? ORDER BY booking_id",

                new ReceptionistMapper(), new Object[]{deskLocation});
    }

    @Override
    public boolean setAttendance(boolean isAttended) {
        return false;
    }
}
