package org.example.reservaHotel02

import java.util.Date

class Reservation(
    val room: Room,
    val client: Client,
    private val beginningDate: Date,
    private val endingDate: Date
) {
    val currentState = getCurrentState()

    private fun getCurrentState(): String {
        val currentDate = Date()

        return when {
            currentDate.before(beginningDate) -> "Pending"
            currentDate.after(endingDate) -> "Finished"
            else -> "Active"
        }
    }


    override fun toString(): String {
        return "Habitación: ${room.number}" +
                " - Cliente: (${client.name} ${client.id})" +
                " - $beginningDate" +
                " - $endingDate" +
                " - $currentState"
    }

}