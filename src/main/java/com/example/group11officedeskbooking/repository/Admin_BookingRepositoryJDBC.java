package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.Admin_BookingDTO;
import com.example.group11officedeskbooking.model.Admin_BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class Admin_BookingRepositoryJDBC implements Admin_BookingRepository{


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Admin_BookingRepositoryJDBC(JdbcTemplate aTemplate){
        jdbcTemplate = aTemplate;
    }

    // All bookings

    @Override
    public List<Admin_BookingDTO> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Booking",
                new Admin_BookingMapper());
    }

    // Updating Bookings

    @Override
    public void update_records(Admin_BookingDTO admin_bookingDTO) {
        jdbcTemplate.update(
                "UPDATE Booking SET booking_date = ? WHERE booking_id = ?",
                admin_bookingDTO.getBooking_date(), admin_bookingDTO.getBooking_id());
    }

    // Delete Bookings

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Booking WHERE booking_id=?", id);
    }

    @Override
    public List<LotteryDTO> getAllLotteryDays(){
        return jdbcTemplate.query(
                "select distinct date, location, resolved from lottery order by date",
                new LotteryMapper());
    }
}
