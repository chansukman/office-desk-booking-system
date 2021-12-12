package com.example.group11officedeskbooking.repository;

import com.example.group11officedeskbooking.DTO.DeskDTO;
import com.example.group11officedeskbooking.DTO.LotteryDTO;
import com.example.group11officedeskbooking.DTO.UserDTO;

import java.util.List;

public interface UserBookingRepository {
    public UserDTO findUserByUserID(int id);
    public Object findUpcomingBookingByUserID(int id);
    public Object findPreviousBookingByUserID(int id);
    public boolean addBooking(int user_id, String date, int desk_id);
    public Object getUniqueBooking(String date, int desk_id);
    public boolean checkLotteryDay(String date, String location);
    public boolean addUserToLottery(String date, String location, int user_id);
    public boolean checkUserInLottery(String date, String location, int user_id);
    public int checkNumberInLottery(String date, String location);
    public int checkNumberInLocation(String location);
    public boolean checkIfUserHasBooking(String date, int user_id);
    public List<LotteryDTO> getAllUsersInLottery(String date, String location);
    public List<DeskDTO> getAllDeskIdInLocation(String location);
    public void resolveLottery(String date, String location);
    public Object getAllUserLotteryEntries(int id);
    public List<UserDTO> getAllUsers();
    public List<String> getAllLocations();
    public Object getNextUserBooking(int user_id);
    public Object getAllBookingFromDateAndLocation(String date, String location);
}
