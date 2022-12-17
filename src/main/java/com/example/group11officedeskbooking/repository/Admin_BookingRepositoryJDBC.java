package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.Admin_BookingDTO;
import com.example.group11officedeskbooking.DTO.LotteryDTO;
import com.example.group11officedeskbooking.DTO.UserDTO;
import com.example.group11officedeskbooking.model.Admin_BookingMapper;
import com.example.group11officedeskbooking.model.LotteryMapper;
import com.example.group11officedeskbooking.model.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Admin_BookingRepositoryJDBC implements Admin_BookingRepository{

    //driver to connect with database
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Admin_BookingRepositoryJDBC(JdbcTemplate aTemplate){
        jdbcTemplate = aTemplate;
    }

    //Get All bookings
    @Override
    public List<Admin_BookingDTO> findAll() {
        return jdbcTemplate.query(
                "SELECT booking_id, booking_date, User_user_id, desk.desk_number, user.first_name, user.last_name, desk.desk_location FROM booking join user ON booking.User_user_id = user.user_id join desk on booking.desk_desk_id=desk.desk_id",
                new Admin_BookingMapper());
    }

    @Override
    public List<LotteryDTO> getAllLotteryDays(){
        return jdbcTemplate.query(
                "select distinct date, location, resolved from lottery order by date",
                new LotteryMapper());
    }

    // Delete Bookings
    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM booking WHERE booking_id=?", id);
    }

    //Find bookings by id
    @Override
    public Admin_BookingDTO findById(int id) {
        return (Admin_BookingDTO) jdbcTemplate.queryForObject(
                    "SELECT booking_id, booking_date, User_user_id, desk.desk_number, user.first_name, user.last_name, desk.desk_location FROM booking join user ON booking.User_user_id = user.user_id join desk on booking.desk_desk_id=desk.desk_id WHERE booking_id = ?",
                new Admin_BookingMapper(),
                new Object[]{id});
    }

}
