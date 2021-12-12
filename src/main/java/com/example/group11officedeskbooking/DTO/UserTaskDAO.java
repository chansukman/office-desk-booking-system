package com.example.group11officedeskbooking.DTO;

public interface UserTaskDAO {
    //to log canceled booking into Cancel table
    public int updateCancelTable(int id);

    //to delete booking by user
    public int deleteBooking(int id);
}
