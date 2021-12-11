package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.Admin_BookingDTO;
import com.example.group11officedeskbooking.DTO.LotteryDTO;

import java.util.List;

public interface Admin_BookingRepository{
    List<Admin_BookingDTO> findAll();
    public List<LotteryDTO> getAllLotteryDays();
    int deleteById(int id);
    Admin_BookingDTO findById(int id);
}
