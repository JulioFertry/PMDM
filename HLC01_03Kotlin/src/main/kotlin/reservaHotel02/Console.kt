package org.example.reservaHotel02

import java.text.SimpleDateFormat
import java.util.Date


class Console {

    fun showMessage(message: String, jumpLine: Boolean = true) {
        if (jumpLine) {
            println(message)
        } else {
            print(message)
        }
    }


    fun readString(): String {
        return readln()
    }


    fun readInt(): Int? {
        try {
            val number = readln().toInt()
            return number
        } catch (e: NumberFormatException) {
            return null
        }
    }


    fun readDate(): Date? {
        val dateFormat = SimpleDateFormat("DD/MM/YYYY")
        println("Ingrese la fecha en formato DD/MM/YYYY:")
        val date = readlnOrNull()

        try {
            if (date != null) {
                return dateFormat.parse(date)
            } else {
                throw Exception("Formato de fecha no válido")
            }
        } catch (e: Exception) {
            showMessage("*** ERROR *** - ($e)")
            return null
        }
    }

}