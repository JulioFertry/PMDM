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


    /** Muestra la información de las reservas de un cliente o de todos los clientes
     *
     * @param clientId Id del cliente
     */
    fun showBookings(clientId: String? = null) {

        if (clientId.isNullOrEmpty()) {
            for (reservation in this.bookings) {
                console.showMessage(reservation.toString(), true)
            }
        } else {
            for (reservation in this.bookings) {
                if (reservation.clientId == clientId) {
                    console.showMessage(reservation.toString(), jumpLine = true)
                }
            }
        }

    }


    /** Introduce un cliente y lo retorna
     *
     * @return Un cliente con los datos introducidos
     */
    private fun insertClient(): Client {
        console.showMessage("Introduce el nombre del cliente: ", false)
        val clientName = console.readString().trim()
        console.showMessage("Introduce el apellido del cliente: ", false)
        val clientSurname = console.readString().trim()

        if (clientName.isEmpty() && clientSurname.isEmpty()) {
            throw Exception("Los datos del cliente son inválidos")
        }

        val clientId = clientName.padEnd(3, '0').take(3) +
                clientSurname.padEnd(3, '0').take(3)
        val client = Client(clientName, clientSurname, clientId)
        return client
    }


    /** Introduce una habitación, la busca en el hotel y la retorna si existe y no está reservada
     *
     * @return la habitación correspondiente al ID introducido
     */
    private fun searchAvailableRoom(): Room {
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
            val room = searchAvailableRoom()
            room.book()
            val reservation = Reservation(room, client)
            this.bookings.add(reservation)
            console.showMessage("Reserva completada con éxito", true)
        } catch (e: Exception) {
            console.showMessage("ERROR al hacer la reserva: ($e)", true)
        }
    }


    /** Comprueba si un cliente tiene reservas
     *
     * @param clientId ID del cliente a comprobar
     *
     * @return Resultado
     */
    private fun clientHasBookings(clientId: String?): Boolean {
        return bookings.any { it.clientId == clientId }
    }


    /** Pide el ID de un cliente y lo devuelve si el cliente tiene una reserva
     *
     * @return ID del cliente on valor nulo
     */
    private fun searchByClientId(): String? {
        console.showMessage("Introduce el id del cliente: ", false)
        val clientId = readln()
        return if (clientHasBookings(clientId)) {
            clientId
        } else {
            null
        }
    }


    /** Pregunta al usuario si quiere eliminar todas las reservas de un cliente y retorna su decisión
     *
     * @return Decisón del usuario
     */
    private fun doCompleteRemoval(): Boolean {
        console.showMessage("Quieres eliminar todas las reservas del cliente? (y/n): ", false)
        val command = readln().lowercase()
        var result = false

        when (command) {
            "y", "yes" -> {
                console.showMessage("Se eliminarán todas las reservas del cliente")
                result = true
            }
            "n", "no" -> {
                console.showMessage("Borrado manual")
            }
            else -> {
                console.showMessage("Respuesta inválida, usa el borrado manual")
            }
        }
        return result
    }


    /** Pide al usuario el id de una habitación y la retorna si existe */
    private fun searchDeletableRooms(): Room {
        console.showMessage("Introduce el número de la habitación: ", false)
        val roomId = console.readString()
        val room = this.rooms.find { it.number == roomId } ?: throw Exception("La habitación no existe")
        if (!room.booked) {
            throw Exception("La habitación no tiene una reserva")
        } else {
            return room
        }
    }


    /** Elimina todas las reservas de un cliente
     *
     * @param clientId ID del cliente
     */
    private fun deleteAllFromClient(clientId: String?) {
        bookings.removeIf { it.clientId == clientId }
        console.showMessage("Todas las reservas eliminadas con éxito")
    }


    /** Elimina una reserva */
    fun cancelReservation() {
        try {
            val clientId = searchByClientId()

            if (clientHasBookings(clientId)) {
                val completeRemoval = doCompleteRemoval()

                if (completeRemoval) {
                    deleteAllFromClient(clientId)
                } else {
                    showBookings(clientId)
                    val room = searchDeletableRooms()
                    val reservation = bookings.find { it.clientId == clientId && it.roomNumber == room.number }
                    if (bookings.remove(reservation)) {
                        console.showMessage("Reserva eliminada con éxito")
                    } else {
                        console.showMessage("No se pudo eliminar la reserva")
                    }
                }

            } else {
                console.showMessage("El cliente introducido no tiene reservas")
                showBookings()
                val room = searchDeletableRooms()
                val reservation = bookings.find {it.roomNumber == room.number }
                if (bookings.remove(reservation)) {
                    console.showMessage("Reserva eliminada con éxito")
                } else {
                    console.showMessage("No se pudo eliminar la reserva")
                }

            }
        } catch (e: Exception) {
            console.showMessage("ERROR al eliminar una reserva: ($e)")
        }
    }


}