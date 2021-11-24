package com.example.group11officedeskbooking.DTO;

public class MapDTO {

    private int map_id;
    private String location;
    private String image;

    public MapDTO(int map_id, String location, String image) {
        this.map_id = map_id;
        this.location = location;
        this.image = image;
    }

    public int getMap_id() {
        return map_id;
    }

    public String getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }
}
