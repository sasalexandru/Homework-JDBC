package org.example;

public class Accommodation {
    private int id;
    private AccommodationType accommodationType;
    private BedType bedType;
    private int maxGuests;
    private String description;


    public Accommodation() {
    }

    public  Accommodation createAccommodation(int id, AccommodationType accommodationType, BedType bedType, int maxGuests, String description) {
        Accommodation accommodation = new Accommodation();
        accommodation.setId(id);
        accommodation.setAccommodationType(accommodationType);
        accommodation.setBedType(bedType);
        accommodation.setMaxGuests(maxGuests);
        accommodation.setDescription(description);
        return accommodation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
