package org.example
import org.example.gestionBiblioteca01.LibraryOperations
import org.example.reservaHotel02.Hotel


fun main() {

    val hotel = Hotel()

    hotel.showBookings()

    hotel.doReservation()
    hotel.doReservation()
    hotel.doReservation()
    hotel.doReservation()
    hotel.doReservation()
    hotel.doReservation()
    hotel.doReservation()
    hotel.doReservation()

    hotel.showBookings()

    hotel.cancelReservation()
    hotel.cancelReservation()
    hotel.cancelReservation()
    hotel.cancelReservation()
    hotel.cancelReservation()
    hotel.cancelReservation()

    hotel.showBookings()

}