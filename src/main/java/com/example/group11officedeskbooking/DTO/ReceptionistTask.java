package com.example.group11officedeskbooking.DTO;

public class ReceptionistTask {
    private int bookingID;
    private int userID;
    private String firstName;
    private String LastName;
    private String deskLocation;
    private int deskNumber;
    private String date;

    public ReceptionistTask() {
    }

    public ReceptionistTask(int bookingID, int userID, String firstName, String lastName, String deskLocation, int deskNumber, String date) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.firstName = firstName;
        LastName = lastName;
        this.deskLocation = deskLocation;
        this.deskNumber = deskNumber;
        this.date = date;
    }

    public int getBookingID() {
        return bookingID;
    }

    public int getUserID() {
        return userID;
    }

    public String getDeskLocation() {
        return deskLocation;
    }

    public int getDeskNumber() {
        return deskNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getDate() {
        return date;
    }
}
