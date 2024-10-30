package org.example;

public class Videojuego {
    private final String titulo;
    private final String plataforma;
    private final int horasJugadas;

    public Videojuego(String titulo, String plataforma, int horasJugadas) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.horasJugadas = horasJugadas;
    }

    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public String toString() {
        return "nombre: " + this.titulo + "\nplataforma: " + this.plataforma + "\nhoras jugadas: " + this.horasJugadas + "\n";
    }
}