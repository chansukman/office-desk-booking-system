package com.example.group11officedeskbooking;
import com.example.group11officedeskbooking.DTO.AdminDTO;
import com.example.group11officedeskbooking.DTO.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private static UserDTO userDTO;
    private static AdminDTO adminDTO;

    @BeforeEach
    void before(){
        userDTO = new UserDTO(24,"shuwen","chen","chens100@cardiff.ac.uk","sales","123456");
        adminDTO = new AdminDTO(1,"admin","admin");


    }
    @Test
     void getUserIdTest(){
        assertEquals(24,userDTO.getUser_id());
    }

    @Test
    void getUserFirstnameTest() {
        assertEquals("shuwen",userDTO.getFirst_name());
    }

    @Test
    void getUserLastnameTest() {
        assertEquals("chen",userDTO.getLast_name());
    }

    @Test
    void getEmailTest() {
        assertEquals("chens100@cardiff.ac.uk",userDTO.getEmail());
    }

    @Test
    void getDepartmentTest() {
        assertEquals("sales",userDTO.getDepartment());
    }

    @Test
    void getPasswordTest() {
        assertEquals("123456",userDTO.getPassword());
    }

    @Test
    void getAdminIdTest() {
        assertEquals(1,adminDTO.getAdmin_id());
    }

    @Test
    void getAdminFirstnameTest() {
        assertEquals("admin",adminDTO.getFirst_name());
    }

    @Test
    void getAdminPasswordTest() {
        assertEquals("admin",adminDTO.getPassword());
    }
}
