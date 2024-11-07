package org.example.reservaHotel02
import java.util.Calendar
import java.util.Date


class HotelOperations {
    private val bookings = mutableListOf<Reservation>()

    fun bookARoom(rooms: List<Room>) {
        try {
            print("Introduce el nombre del cliente: ")
            val clientName = readln()
            print("Introduce el apellido del cliente: ")
            val clientSurname = readln()
            val clientId = clientName.take(3) + clientSurname.take(3)
            val client = Client(clientName, clientSurname, clientId)
            print("Introduce el número de la habitación: ")
            val roomId = readln().toInt()
            val room = rooms.find { it.number == roomId }
            if (room == null) {
                throw Exception("La habitacion no existe")
            }

            val bookingDate = Date()
            val calendar = Calendar.getInstance()
            calendar.time = bookingDate
            calendar.add(Calendar.WEEK_OF_YEAR, 1)
            val endingDate = calendar.time

            val reservation = Reservation(room, client, bookingDate, endingDate)
        } catch (e: Exception) {
            println("*** ERROR *** - ($e)")
        }

    }

}