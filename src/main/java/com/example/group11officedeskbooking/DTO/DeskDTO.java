package com.example.group11officedeskbooking.DTO;

public class DeskDTO {

    private int desk_id;
    private boolean has_window;
    private int desk_location;

    public DeskDTO(int desk_id, boolean has_window, int desk_location) {
        this.desk_id = desk_id;
        this.has_window = has_window;
        this.desk_location = desk_location;
    }

    public int getDesk_id() {
        return desk_id;
    }

    public boolean isHas_window() {
        return has_window;
    }

    public int getDesk_location() {
        return desk_location;
    }
}
