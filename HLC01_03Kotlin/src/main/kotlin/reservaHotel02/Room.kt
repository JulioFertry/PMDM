package org.example.reservaHotel02

data class Room(
    val number: String,
    val price: Double,
) {
    var booked: Boolean = false
        private set


    fun book() {
        booked = true
    }


    fun unBook() {
        booked = false
    }


    override fun toString(): String {
        return "Habitación: $number - Precio: $price - Estado: ${if (booked) {"Reservada"} else {"Libre"}}"
    }
}