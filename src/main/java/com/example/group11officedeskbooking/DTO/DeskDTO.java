package com.example.group11officedeskbooking.DTO;

public class DeskDTO {

    private int desk_id;
    private boolean has_window;
    private String desk_type;

    public DeskDTO(int desk_id, boolean has_window, String desk_type) {
        this.desk_id = desk_id;
        this.has_window = has_window;
        this.desk_type = desk_type;
    }

    public int getDesk_id() {
        return desk_id;
    }

    public boolean isHas_window() {
        return has_window;
    }

    public String getDesk_type() {
        return desk_type;
    }
}
