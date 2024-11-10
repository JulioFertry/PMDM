package org.example.reservaHotel02


class Reservation(
    room: Room,
    private val client: Client,
) {
    val clientId = client.id
    val roomNumber = room.number

    override fun toString(): String {
        return "Habitación: $roomNumber - Cliente: ${client.name} ${client.surname}"
    }

}