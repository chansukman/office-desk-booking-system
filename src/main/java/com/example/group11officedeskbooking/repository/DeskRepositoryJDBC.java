package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.DeskDTO;
import com.example.group11officedeskbooking.model.DeskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeskRepositoryJDBC implements DeskRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DeskRepositoryJDBC(JdbcTemplate aTemplate){
        jdbcTemplate = aTemplate;
    }

    @Override
    public List<DeskDTO> searchAvailableDesksByDate(String searchDate){
        return jdbcTemplate.query(
                "select * from desk where desk_id not in (select Desk_desk_id from booking where booking_date=?)",
                new DeskMapper(), new Object[]{searchDate});
    }
}
