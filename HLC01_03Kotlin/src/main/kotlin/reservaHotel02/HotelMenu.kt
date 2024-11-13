package org.example.reservaHotel02

class HotelMenu(private val console: Console = Console()) {
    private val hotel = Hotel()


    private fun askForOption(): String {
        console.showMessage("1 para hacer una reserva\n" +
                " 2 para cancelar una reserva\n" +
                "3 para ver todas las reservas\n" +
                "0 para salir\n" +
                "---------> ", true)
        val option = readln()
        console.showMessage("", true)
        return option
    }


    private fun performOption(option: String) {
        when (option) {
            "0" -> println("Adios")
            "1" -> hotel.doReservation()
            "2" -> hotel.cancelReservation()
            "3" -> hotel.showBookings()
            else -> console.showMessage("La opción introducida no existe...")
        }
    }


    fun executeMenu() {
        var option = "hola"
        try {
            while (option != "0") {
                option = askForOption()
                performOption(option)
            }

        } catch (e: Exception) {
            println("*** ERROR *** - $e")
        }
    }

}