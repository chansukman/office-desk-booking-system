package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.UserDTO;

import java.util.List;

public interface UserRepository {
    public Object checkByFirstnameAndPassword(String first_name,String password);
    public Object checkAdminByFistnameAndPassword(String first_name,String passsword);

}

