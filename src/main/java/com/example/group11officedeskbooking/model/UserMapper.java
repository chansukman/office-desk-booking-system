package com.example.group11officedeskbooking.model;

import com.example.group11officedeskbooking.DTO.AdminDTO;
import com.example.group11officedeskbooking.DTO.UserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs,int num)throws SQLException{
        UserDTO userDTO = new UserDTO(rs.getString("first_name"),rs.getString("password"));

        return userDTO;

    }

}
