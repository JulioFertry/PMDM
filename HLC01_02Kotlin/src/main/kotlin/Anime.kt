class Anime (
    private val nombre: String,
    private val episodios: Int,
    private val genero: String
) {

    override fun toString(): String {
        return "nombre: $nombre\nepisodios: $episodios\ngenero: $genero"
    }

}