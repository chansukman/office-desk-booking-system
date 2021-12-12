package com.example.group11officedeskbooking.repository;

public interface MapRepository {
    public Object searchMap(String location);
    public boolean addMap(String mapLocation, String image);
}
