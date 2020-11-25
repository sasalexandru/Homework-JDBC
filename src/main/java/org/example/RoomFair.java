package org.example;

public class RoomFair {
    private int id;
    private double value;
    private Season season;

    public RoomFair() {

    }

    public  RoomFair createRoomFair(int id, double value, Season season) {
        RoomFair roomFair = new RoomFair();
        roomFair.setId(id);
        roomFair.setValue(value);
        roomFair.setSeason(season);
        return roomFair;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
