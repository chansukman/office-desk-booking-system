package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.DeskDTO;

public interface DeskRepository {
    public Object searchAvailableDesksByDate(String searchDate, String deskLocation);
    public DeskDTO findById(int desk_id);
}
