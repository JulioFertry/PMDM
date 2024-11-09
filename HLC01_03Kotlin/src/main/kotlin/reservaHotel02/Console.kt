package org.example.reservaHotel02


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

}