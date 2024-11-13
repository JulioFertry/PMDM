package org.example
import gestorTareas05.TaskMenu
import org.example.gestionBiblioteca01.LibraryOperations
import org.example.gestionEstudiantes04.SchoolMenu
import org.example.juegoRol03.FightMenu
import org.example.reservaHotel02.HotelMenu


fun main() {
    val library = LibraryOperations()
    val hotel = HotelMenu()
    val rpg = FightMenu()
    val school = SchoolMenu()
    val task = TaskMenu()

    fun askForOption(): String {
        println("1 act1\n" +
                "2 act2\n" +
                "3 act3\n" +
                "4 act4\n" +
                "5 act5\n" +
                "----> ")
        val option = readln()
        return option
    }


    fun performOption(option: String) {
        when (option) {
            "0" -> println("Adios")
            "1" -> library.appMenu()
            "2" -> hotel.executeMenu()
            "3" -> rpg.fight()
            "4" -> school.executeMenu()
            "5" -> task.executeMenu()
            else -> println("La opción introducida no existe...")
        }
    }


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