package org.example;


import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) {
        BookingDB bookingDB = new BookingDB();
        Relation relation = new Relation();
        RoomFair roomFair = new RoomFair();
        Accommodation accommodation = new Accommodation();
        List<Accommodation> accommodations = new ArrayList<>();
        List<RoomFair> roomFairs = new ArrayList<>();
        List<Relation> relations = new ArrayList<>();




        roomFairs.add(roomFair.createRoomFair(1, 90.5, Season.SPRING));
        roomFairs.add(roomFair.createRoomFair(2, 120.5, Season.SUMMER));
        roomFairs.add(roomFair.createRoomFair(3, 95.5, Season.AUTUMN));

        accommodations.add((accommodation.createAccommodation(1, AccommodationType.SINGLE, BedType.SINGLE, 5, " Single Bed ")));
        accommodations.add(accommodation.createAccommodation(2, AccommodationType.PENTHOUSE, BedType.QUEEN, 2, " Queen Size Bed  "));
        accommodations.add(accommodation.createAccommodation(3, AccommodationType.VIP, BedType.KING, 2, " King Size Bed "));


        for (Accommodation accommodation1 : accommodations) {
            int pKeyAccommodation = accommodation1.getId();
            String type = accommodation1.getAccommodationType().toString();
            String bedType = accommodation1.getBedType().toString();
            int maxGuests = accommodation1.getMaxGuests();
            String description = accommodation1.getDescription();
            bookingDB.insertIntoAccommodation(pKeyAccommodation, type, bedType, maxGuests, description);

        }
        for (RoomFair rf : roomFairs) {
            int pKeyRoomFair = rf.getId();
            double value = rf.getValue();
            Season season = rf.getSeason();
            bookingDB.insertIntoRoomFair(pKeyRoomFair, value, season);
        }
        for (int i = 0; i < roomFairs.size(); i++) {
            int pKeyRelation = i + 1;
            Accommodation acmd = accommodations.get(i);
            RoomFair rf = roomFairs.get(i);
            relations.add(relation.createRelation(pKeyRelation, acmd, rf));
        }
        for (Relation rel : relations) {
            int pKeyRelation = rel.getId();
            int fKeyAccommodation = rel.getAccommodation().getId();
            int fKeyRoomFair = rel.getRoomFair().getId();
            bookingDB.insertIntoRelation(pKeyRelation, fKeyAccommodation, fKeyRoomFair);

        }

        bookingDB.printResult();

    }
}
