package org.example.reservaHotel02

import java.util.*

class Hotel(private val console: Console = Console()) {

    private val rooms = mutableListOf<Room>()
    private val bookings = mutableListOf<Reservation>()

    companion object {
        const val FLOORS = 4
        const val ROOMS_PER_FLOOR = 4
    }

    init {
        initializeRooms()
    }


    /** Añade todas las habitaciones del hotel a la lista de habitaciones */
    private fun initializeRooms() {
        var actualRoomPrice = 50.0

        for (floor in 0 until FLOORS) {
            val floorNumber = floor.toString()
            actualRoomPrice += 50.0

            for (room in 1..ROOMS_PER_FLOOR) {
                val roomNumber = "${floorNumber}0${room}"
                val newRoom = Room(roomNumber, actualRoomPrice)
                this.rooms.add(newRoom)
            }
        }
    }


    private fun createEndDate(initDate: Date?): Date {
        val calendar = Calendar.getInstance()
        calendar.time = initDate
        calendar.add(Calendar.WEEK_OF_YEAR, 1)
        return calendar.time
    }


    /** Reserva una habitación a un cliente
     *
     *
     */
    fun bookARoom() {
        console.showMessage("Introduce el nombre del cliente: ", false)
        val clientName = console.readString()
        console.showMessage("Introduce el apellido del cliente: ", false)
        val clientSurname = console.readString()
        val clientId = clientName.padEnd(3, '0').take(3) +
                clientSurname.padEnd(3, '0').take(3)

        console.showMessage("Introduce el número de la habitación: ", false)
        val roomId = console.readString()
        val room = rooms.find { it.number == roomId }

        console.showMessage("Introduce la fecha de inicio de la reserva en formato DD/MM/YYYY: ")
        val initDate = console.readDate()
        val endDate = createEndDate(initDate)


    }


}