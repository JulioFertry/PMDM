package org.example.reservaHotel02

import java.util.Date

class Reservation(
    private val room: Room,
    private val client: Client,
) {

    override fun toString(): String {
        return "Habitación: ${room.number}" +
                " - Cliente: (${client.name} ${client.id})"
    }

}