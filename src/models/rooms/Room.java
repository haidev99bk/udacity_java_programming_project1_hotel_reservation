package models.rooms;

import models.rooms.enums.RoomType;

public class Room implements IRoom {
    private String roomNumber;
    private Double price;
    RoomType type;

    public Room(String number, Double price, RoomType type) {
        this.roomNumber = number;
        this.price = price;
        this.type = type;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public Double getRoomPrice() {
        return this.price;
    }

    public RoomType getRoomType() {
        return this.type;
    }

    public boolean isFree() {
        return this.price == null || this.price.equals (0.0);
    }

    @Override
    public String toString() {
        return new String ("Room: \n" +
                "* Number: " + this.roomNumber + "\n" +
                "* Price: " + this.price + "\n" +
                "* Type: " + this.type);
    }
}
