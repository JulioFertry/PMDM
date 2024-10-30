package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.Iterator;


public class InventoryUtils {
    Scanner scanner = new Scanner(System.in);

    public void addVideogame(List<Videojuego> inventory) {
        System.out.print("Introduce el nombre del videojuego: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce la plataforma: ");
        String plataforma = scanner.nextLine();
        System.out.print("Introduce la cantidad de horas jugadas: ");
        int horas = Integer.parseInt(scanner.nextLine());

        Videojuego videojuego = new Videojuego(nombre, plataforma, horas);
        inventory.add(videojuego);
    }

    public void deleteVideogame(List<Videojuego> inventory) {
        System.out.print("Introduce el nombre del videojuego que quieres eliminar: ");
        String nombre = scanner.nextLine();
        int counter = 0;

        Iterator<Videojuego> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            Videojuego videojuego = iterator.next();
            if (videojuego.getTitulo().equals(nombre)) {
                iterator.remove(); // Remueve el videojuego utilizando el iterador
                counter++;
            }
        }

        System.out.println(counter + " juegos eliminados");
    }

    public void showInventory(List<Videojuego> inventory) {
        for (Videojuego videojuego : inventory) {
            System.out.println(videojuego.toString());
        }
    }
}

