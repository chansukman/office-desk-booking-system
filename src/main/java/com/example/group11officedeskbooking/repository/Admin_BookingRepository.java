package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.Admin_BookingDTO;

import java.util.List;

public interface Admin_BookingRepository{
    List<Admin_BookingDTO> findAll();
}
