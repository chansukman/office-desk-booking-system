package com.example.group11officedeskbooking.model;

import com.example.group11officedeskbooking.DTO.AdminDTO;
import com.example.group11officedeskbooking.DTO.UserDTO;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper implements org.springframework.jdbc.core.RowMapper {
    @Override
    public Object mapRow(ResultSet rs,int num)throws SQLException{
        AdminDTO adminDTO=new AdminDTO(rs.getInt("admin_id"),rs.getString("first_name"),rs.getString("password"));
        return adminDTO;

    }

}
