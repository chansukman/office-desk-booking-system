package com.example.group11officedeskbooking.forms;

public class DeskForm {

    String name;
    String type;
    String image;
    String status;

    public DeskForm(String name, String type, String image, String status) {
        this.name = name;
        this.type = type;
        this.image = image;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getImage() {
        return image;
    }

    public String getStatus() {
        return status;
    }
}
