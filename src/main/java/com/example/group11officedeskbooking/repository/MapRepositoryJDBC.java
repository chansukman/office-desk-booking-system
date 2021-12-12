package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.MapDTO;
import com.example.group11officedeskbooking.model.MapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MapRepositoryJDBC implements MapRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MapRepositoryJDBC(JdbcTemplate aTemplate){
        jdbcTemplate = aTemplate;
    }

    @Override
    public MapDTO searchMap(String location) {
        MapDTO mapDTO = (MapDTO) jdbcTemplate.queryForObject(
                "select * from maps where location=?",
                new MapMapper(), new Object[]{location});
        return mapDTO;
    }

    @Override
    public boolean addMap(String mapLocation, String image){
        int rows = jdbcTemplate.update(
                "insert into Maps(location, image) values(?,?)",
                new Object[]{mapLocation, image});
        return rows > 0;
    }


}
