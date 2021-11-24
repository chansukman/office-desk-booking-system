package com.example.group11officedeskbooking.repository;
import com.example.group11officedeskbooking.DTO.AdminDTO;
import com.example.group11officedeskbooking.DTO.UserDTO;
import com.example.group11officedeskbooking.model.AdminMapper;
import com.example.group11officedeskbooking.model.DeskMapper;
import com.example.group11officedeskbooking.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryJDBC implements UserRepository{
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public UserRepositoryJDBC(JdbcTemplate userTemplate) {
        jdbcTemplate = userTemplate;
    }

    @Override
    public UserDTO checkByFirstnameAndPassword(String first_name,String password){
        String sql="select * from user where first_name=? and password=? ";
        return (UserDTO) jdbcTemplate.queryForObject(sql,new Object[]{first_name, password},
                new UserMapper() );
    }
    public AdminDTO checkAdminByFistnameAndPassword(String first_name,String password){
        String sql="select * from admin where first_name=? and password=?";
        return (AdminDTO) jdbcTemplate.queryForObject(sql,new Object[]{first_name, password},
                new AdminMapper() );

    }


}
