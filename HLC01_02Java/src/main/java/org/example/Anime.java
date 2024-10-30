package org.example;

public class Anime {
    private final String nombre;
    private final int episodios;
    private final String genero;

    public Anime(String nombre, int episodios, String genero) {
        this.nombre = nombre;
        this.episodios = episodios;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "nombre: " + this.nombre + "\nepisodios: " + this.episodios + "\ngenero: " + this.genero;
    }
}