package com.example.group11officedeskbooking.repository;

public interface UserBookingRepository {
    public Object findBookingByUserId(int id);
    public boolean addBooking(int user_id, String date, int desk_id);
    public Object getUniqueBooking(String date, int desk_id);
    public boolean checkLotteryDay(String date, String location);
    public boolean addUserToLottery(String date, String location, int user_id);
    public boolean checkUserInLottery(String date, String location, int user_id);
}
