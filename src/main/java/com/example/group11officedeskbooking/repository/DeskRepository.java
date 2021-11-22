package com.example.group11officedeskbooking.repository;

public interface DeskRepository {
    public Object searchAvailableDesksByDate(String searchDate, String deskLocation);
}
