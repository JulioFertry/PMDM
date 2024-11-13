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

}