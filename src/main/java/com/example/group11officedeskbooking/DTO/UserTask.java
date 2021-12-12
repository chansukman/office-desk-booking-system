package com.example.group11officedeskbooking.DTO;

public class UserTask {
    private int id;
    private String bookingDate;
    private int userId;
    private int deskId;

    public UserTask() {
    }

    public UserTask(int id, String bookingDate, int userId, int deskId) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.userId = userId;
        this.deskId = deskId;
    }
    public UserTask(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    public int getId() {
        return id;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public int getUserId() {
        return userId;
    }

    public int getDeskId() {
        return deskId;
    }
}
