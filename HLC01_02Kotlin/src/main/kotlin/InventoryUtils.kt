class InventoryUtils {

    fun addVideogame(inventory: MutableList<Videojuego>) {
        print("Introduce el nombre del videojuego: ")
        val nombre = readln()
        print("Introduce la plataforma: ")
        val plataforma = readln()
        print("Introduce la cantidad de horas jugadas: ")
        val horas = readln().toInt()

        val videojuego = Videojuego(nombre, plataforma, horas)
        inventory.add(videojuego)
    }


    fun deleteVideogame(inventory: MutableList<Videojuego>) {
        print("Introduce el nombre del videojuego que quieres eliminar: ")
        val nombre = readln()
        var counter = 0

        for (videojuego in inventory) {
            if (videojuego.titulo == nombre) {
                inventory.remove(videojuego)
                counter += 1
            }
        }

        println("$counter juegos eliminados")
    }


    fun showInventory(inventory: List<Videojuego>) {
        for (videojuego in inventory) {
            println(videojuego.toString())
        }
    }

}