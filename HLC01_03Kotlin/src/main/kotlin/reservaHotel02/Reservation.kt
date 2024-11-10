package org.example.reservaHotel02


class Reservation(
    private val room: Room,
    private val client: Client,
) {

    override fun toString(): String {
        return "Habitación: ${room.number} - Cliente: ${client.name} ${client.surname}"
    }

}