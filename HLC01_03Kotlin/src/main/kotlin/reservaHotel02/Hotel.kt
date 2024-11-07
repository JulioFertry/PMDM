package org.example.reservaHotel02

class Hotel {

    val operator = HotelOperations()
    private val rooms = mutableListOf<Room>()

    init {
        rooms.add(Room(1, 110.0, false))
        rooms.add(Room(2, 140.0, false))
        rooms.add(Room(3, 140.0, false))
        rooms.add(Room(4, 185.0, false))
        rooms.add(Room(5, 185.0, false))
        rooms.add(Room(6, 185.0, false))
        rooms.add(Room(7, 185.0, false))
        rooms.add(Room(8, 200.0, false))
        rooms.add(Room(9, 200.0, false))
        rooms.add(Room(10, 200.0, false))
        rooms.add(Room(11, 250.0, false))
    }

}