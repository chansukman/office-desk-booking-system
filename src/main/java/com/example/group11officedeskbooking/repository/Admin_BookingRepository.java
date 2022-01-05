package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.Admin_BookingDTO;
import com.example.group11officedeskbooking.DTO.LotteryDTO;

import java.util.List;

public interface Admin_BookingRepository{
    //method to get all records
    List<Admin_BookingDTO> findAll();
    //method to get All lottery days
    List<LotteryDTO> getAllLotteryDays();
    //method to delete a record by its id
    int deleteById(int id);
    //method to find a specific record by its id
    Admin_BookingDTO findById(int id);
}
