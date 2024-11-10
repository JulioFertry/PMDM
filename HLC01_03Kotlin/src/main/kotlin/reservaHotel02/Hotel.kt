package org.example.reservaHotel02


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


    /** Muestra la información de las habitaciones que están disponibles */
    private fun showAvailableRooms() {
        console.showMessage("Habitaciones disponibles: ", true)
        for (room in this.rooms) {
            if (!room.booked){
                console.showMessage(room.toString(), true)
            }
        }
    }


    /** Muestra la información de todas las reservas del hotel */
    fun showBookings() {
        for (reservation in this.bookings) {
            console.showMessage(reservation.toString(), true)
        }
    }


    /** Introduce un cliente y lo retorna
     *
     * @return Un cliente con los datos introducidos
     */
    private fun insertClient(): Client {
        console.showMessage("Introduce el nombre del cliente: ", false)
        val clientName = console.readString()
        console.showMessage("Introduce el apellido del cliente: ", false)
        val clientSurname = console.readString()
        val clientId = clientName.padEnd(3, '0').take(3) +
                clientSurname.padEnd(3, '0').take(3)
        val client = Client(clientName, clientSurname, clientId)
        return client
    }


    /** Introduce una habitación, la busca en el hotel y la retorna si existe y no está reservada
     *
     * @return la habitación correspondiente al ID introducido
     */
    private fun insertRoom(): Room {
        console.showMessage("Introduce el número de la habitación: ", false)
        val roomId = console.readString()
        val room = this.rooms.find { it.number == roomId } ?: throw Exception("La habitación no existe")
        if (room.booked) {
            throw Exception("La habitación ya está reservada")
        } else {
            return room
        }
    }


    /** Reserva una habitación a un cliente */
    fun doReservation() {
        try {
            val client = insertClient()
            showAvailableRooms()
            val room = insertRoom()
            room.book()
            val reservation = Reservation(room, client)
            this.bookings.add(reservation)
            console.showMessage("Reserva completada con éxito", true)
        } catch (e: Exception) {
            console.showMessage("ERROR al hacer la reserva: ($e)", true)
        }
    }





    fun cancelReservation() {

    }


}