fun main() {
    val menu = Menu()
    var option = "hola"

    try {
        while (option != "0") {
            option = menu.askForOption()
            menu.performOption(option)
        }

    } catch (e: Exception) {
        println("*** ERROR *** - $e")
    }

}