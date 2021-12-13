package com.example.group11officedeskbooking.DTO;

public interface UserTaskDAO {
    //to log canceled booking into Cancel table
    public int updateCancelTable(int id);

    //to delete booking by user
    public int deleteBooking(int id);

    //to list daily booking for the reception-desk
    public Object getDailyBooking(String deskLocation);

    //to mark booking as true when booking holder come to office
    public boolean setAttendance(boolean isAttended);
}
