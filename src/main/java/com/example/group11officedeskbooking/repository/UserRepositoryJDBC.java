package com.example.group11officedeskbooking.repository;
import com.example.group11officedeskbooking.DTO.AdminDTO;
import com.example.group11officedeskbooking.DTO.GithubUser;
import com.example.group11officedeskbooking.DTO.UserDTO;
import com.example.group11officedeskbooking.model.AdminMapper;
import com.example.group11officedeskbooking.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryJDBC implements UserRepository{
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public UserRepositoryJDBC(JdbcTemplate userTemplate) {
        jdbcTemplate = userTemplate;
    }

    @Override

    //check username and password in database
    public UserDTO checkByFirstnameAndPassword(String first_name,String password){
        String sql="select * from user where first_name=? and password=? ";
        return (UserDTO) jdbcTemplate.queryForObject(sql,new Object[]{first_name, password},
                new UserMapper() );
    }

    //check admin name and password in database
    public AdminDTO checkAdminByFistnameAndPassword(String first_name,String password){
        String sql="select * from admin where first_name=? and password=?";
        return (AdminDTO) jdbcTemplate.queryForObject(sql,new Object[]{first_name, password},
                new AdminMapper() );

    }

    //add the SSO login user in database
    public boolean addSSOUser(Integer user_id, String first_name){
        int rows = jdbcTemplate.update("insert into user(user_id, first_name) values(?,?)",
        new Object[]{user_id, first_name});
        return rows>0;
    }

    //check the SSO login user exist or not in the database
    public UserDTO checkUserExist(Integer user_id) {
        String sql="select * from user where user_id=?";
        return (UserDTO) jdbcTemplate.queryForObject(sql,new Object[]{user_id},
                new UserMapper() );
    }
}
