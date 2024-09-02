package models.rooms;

import models.rooms.enums.RoomType;

public class FreeRoom extends Room {
    public FreeRoom(String number, RoomType type) {
        super (number, 0.0, type);
    }

   
}
