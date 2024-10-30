class Videojuego (
    val titulo: String,
    private val plataforma: String,
    private val horasJugadas: Int
) {

    override fun toString(): String {
        return "nombre: $titulo\nplataforma: $plataforma\nhoras jugadas: $horasJugadas\n"
    }

}