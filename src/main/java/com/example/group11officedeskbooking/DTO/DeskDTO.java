package com.example.group11officedeskbooking.DTO;

public class DeskDTO {

    private int desk_id;
    private int desk_number;
    private boolean has_monitors;
    private String desk_type;
    private String desk_location;

    public DeskDTO(int desk_id, int desk_number, boolean has_monitors, String desk_type, String desk_location) {
        this.desk_id = desk_id;
        this.desk_number = desk_number;
        this.has_monitors = has_monitors;
        this.desk_type = desk_type;
        this.desk_location = desk_location;
    }

    public int getDesk_id() {
        return desk_id;
    }

    public int getDesk_number() { return desk_number; }

    public boolean isHas_monitors() {
        return has_monitors;
    }

    public String getDesk_type() {
        return desk_type;
    }

    public String getDesk_location(){ return desk_location;}
}
