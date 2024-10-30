class Menu {

    fun askForOption(): String {
        print("\nIntroduce el numero de la actividad (1-14) o 0 para salir: ")
        val option = readln()
        print("\n")
        return option
    }

    fun performOption(option: String) {
        when (option) {
            "0" -> println("Adios")
            "1" -> Actividades.ej01()
            "2" -> Actividades.ej02()
            "3" -> Actividades.ej03()
            "4" -> Actividades.ej04()
            "5" -> Actividades.ej05()
            "6" -> Actividades.ej06()
            "7" -> Actividades.ej07()
            "8" -> Actividades.ej08()
            "9" -> Actividades.ej09()
            "10" -> Actividades.ej10()
            "11" -> Actividades.ej11()
            "12" -> Actividades.ej12()
            "13" -> Actividades.ej13()
            "14" -> Actividades.ej14()
            else -> println("La opción introducida no existe...")
        }
    }

}