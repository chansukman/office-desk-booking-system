package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.DeskDTO;
import com.example.group11officedeskbooking.DTO.UserDTO;
import com.example.group11officedeskbooking.model.DeskMapper;
import com.example.group11officedeskbooking.model.UserInfoMapper;
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
    public List<DeskDTO> searchAvailableDesksByDate(String searchDate, String deskLocation){
        return jdbcTemplate.query(
                "select * from desk where desk_location=? and desk_id not in (select Desk_desk_id from booking where booking_date=?)",
                new DeskMapper(), new Object[]{deskLocation, searchDate});
    }

    @Override
    public DeskDTO findById(int desk_id) {
        return (DeskDTO) jdbcTemplate.queryForObject(
                "select * from desk where desk_id=?",
                new DeskMapper(),
                new Object[]{desk_id});
    }
}
