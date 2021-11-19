package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.DeskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeskRepositoryJDBC implements DeskRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DeskRepositoryJDBC(JdbcTemplate aTemplate){
        jdbcTemplate = aTemplate;
    }

    @Override
    public DeskDTO searchAvailableDesksByDate(String searchDate){
        DeskDTO deskDTO = (DeskDTO) jdbcTemplate.queryForObject(
                "select * from desk where desk_id not in (select Desk_desk_id from booking where booking_date=?)",
                new Object[]{searchDate}, new deskMapper());
        return deskDTO;
        )
    }
}
