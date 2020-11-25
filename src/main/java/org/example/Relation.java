package org.example;

public class Relation {
    int id;
    Accommodation accommodation;
    RoomFair roomFair;

    public Relation() {

    }

    public  Relation createRelation(int id, Accommodation accommodation, RoomFair roomFair) {
        Relation relation = new Relation();
        relation.setId(id);
        relation.setAccommodation(accommodation);
        relation.setRoomFair(roomFair);
        return relation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public RoomFair getRoomFair() {
        return roomFair;
    }

    public void setRoomFair(RoomFair roomFair) {
        this.roomFair = roomFair;
    }
}
