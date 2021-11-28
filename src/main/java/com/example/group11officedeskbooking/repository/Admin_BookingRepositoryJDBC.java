package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.Admin_BookingDTO;
import com.example.group11officedeskbooking.model.Admin_BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Admin_BookingRepositoryJDBC implements Admin_BookingRepository{


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Admin_BookingRepositoryJDBC(JdbcTemplate aTemplate){
        jdbcTemplate = aTemplate;
    }

    @Override
    public List<Admin_BookingDTO> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Booking",
                new Admin_BookingMapper());
    }
}
