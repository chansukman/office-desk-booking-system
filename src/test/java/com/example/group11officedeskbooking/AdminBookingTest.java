package com.example.group11officedeskbooking;

import com.example.group11officedeskbooking.DTO.Admin_BookingDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdminBookingTest {

    private static Admin_BookingDTO admin_bookingDTO;

    @BeforeAll

    public static void before(){
        admin_bookingDTO = new Admin_BookingDTO(1, "2021-11-20",24,14,"Mahad","Khurshid","Bristol");
    }

    @Test
    public void GetIdTest(){
        assertEquals(1, admin_bookingDTO.getBooking_id());
    }

    @Test
    public void GetDateTest(){
        assertEquals("2021-11-20",admin_bookingDTO.getBooking_date());
    }

    @Test
    public void GetUserIdTest(){
        assertEquals(24,admin_bookingDTO.getUser_user_id());
    }

    @Test
    public void GetDeskNumberTest(){assertEquals(14, admin_bookingDTO.getDesk_number());}

    @Test
    public void GetFirstNameTest(){assertEquals("Mahad",admin_bookingDTO.getFirst_name());}

    @Test
    public void GetLastNameTest(){assertEquals("Khurshid",admin_bookingDTO.getLast_name());}

    @Test
    public void GetDeskLocationTest(){assertEquals("Bristol",admin_bookingDTO.getDesk_location());}
}
