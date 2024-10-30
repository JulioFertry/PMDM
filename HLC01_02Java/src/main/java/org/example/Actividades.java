package org.example;

import java.util.*;


public class Actividades {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();


    public void ej01() {
        System.out.print("Dime tu nombre: ");
        String name = scanner.nextLine();
        System.out.println("¡Hola, " + name + "!");
    }


    public void ej02() {
        System.out.print("Dame un numero entero: ");
        int number = Integer.parseInt(scanner.nextLine());

        if (number % 2 == 0) {
            System.out.println("Es par");
        } else {
            System.out.println("Es impar");
        }
    }


    public void ej03() {
        System.out.print("Dame un numero positivo: ");
        double radio = Double.parseDouble(scanner.nextLine());

        double pi = 3.14159;
        double area = pi * (radio * radio);
        System.out.println("El area de un circulo de radio " + radio + " es de " + area);
    }


    public void ej04() {
        int randomNumber = random.nextInt(100) + 1;
        int guessNumber = 0;

        while (guessNumber != randomNumber) {
            System.out.print("Introduce un numero del 1 al 100: ");
            guessNumber = Integer.parseInt(scanner.nextLine());

            if (guessNumber < randomNumber) {
                System.out.println("El número ingresado es MENOR que el número que buscas");
            } else if (guessNumber > randomNumber) {
                System.out.println("El número ingresado es MAYOR que el número que buscas");
            } else {
                System.out.println("¡Has acertado!");
            }
        }
    }


    public void ej05() {
        System.out.print("Dame un numero positivo: ");
        int number = Integer.parseInt(scanner.nextLine());

        System.out.println("Tabla del " + number);
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
    }


    public void ej06() {
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            sum += i;
        }

        System.out.println("Sumatorio del 1 al 100 = " + sum);
    }


    public void ej07() {
        System.out.print("Introduce una palabra/frase: ");
        String phrase = scanner.nextLine();
        StringBuilder newPhrase = new StringBuilder();

        for (int i = phrase.length() - 1; i >= 0; i--) {
            newPhrase.append(phrase.charAt(i));
        }

        System.out.println(newPhrase);
    }


    public void ej08() {
        String vowels = "aeiou";
        int vowelCount = 0;

        System.out.print("Introduce una palabra/frase: ");
        String phrase = scanner.nextLine().toLowerCase();

        for (char i : phrase.toCharArray()) {
            if (vowels.indexOf(i) != -1) {
                vowelCount += 1;
            }
        }

        System.out.println("Tu frase tiene " + vowelCount + " vocales");
    }


    public void ej09() {
        boolean esPrimo = true;
        System.out.print("Dame un numero entero: ");
        int number = Integer.parseInt(scanner.nextLine());

        if (number == 1) {
            esPrimo = false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    esPrimo = false;
                    break;
                }
            }
        }

        if (esPrimo) {
            System.out.println("El " + number + " es primo");
        } else {
            System.out.println("El " + number + " no es primo");
        }
    }


    public void ej10() {
        System.out.print("Introduce la temperatura en Celsius: ");
        double temp1 = Double.parseDouble(scanner.nextLine());
        double fah = temp1 * 9 / 5 + 32;
        System.out.println(temp1 + " grados Celsius son " + fah + " grados Fahrenheit");

        System.out.print("Introduce la temperatura en Fahrenheit: ");
        double temp2 = Double.parseDouble(scanner.nextLine());
        double cel = (temp2 - 32) * 5 / 9;
        System.out.println(temp2 + " grados Fahrenheit son " + cel + " grados Celsius");
    }


    public void ej11() {
        System.out.print("Introduce un numero: ");
        int number = Integer.parseInt(scanner.nextLine());

        int oldNumber = 0;
        int newNumber = 1;

        System.out.println(oldNumber);
        if (number != 1) {
            System.out.println(newNumber);
            for (int i = 0; i < number - 2; i++) {
                int currentNumber = newNumber;
                newNumber += oldNumber;
                oldNumber = currentNumber;
                System.out.println(newNumber);
            }
        }
    }


    public void ej12() {
        System.out.print("Introduce un numero entero: ");
        int number = Integer.parseInt(scanner.nextLine());
        int normalNumber = number;
        int reversedNumber = 0;

        while (normalNumber != 0) {
            int digit = normalNumber % 10;
            reversedNumber = reversedNumber * 10 + digit;
            normalNumber /= 10;
        }

        System.out.println(number + " ---> " + reversedNumber);
    }


    public void ej13() {
        System.out.print("Introduce el nombre del anime: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduce la cantidad de capitulos: ");
        int capitulos = Integer.parseInt(scanner.nextLine());

        System.out.print("Introduce el genero del anime: ");
        String genero = scanner.nextLine();

        Anime anime = new Anime(nombre, capitulos, genero);
        System.out.println(anime);
    }


    public void ej14() {
        List<Videojuego> inventario = new ArrayList<>();
        InventoryUtils utilities = new InventoryUtils();
        String option = "hola";

        while (!option.equals("0")) {
            System.out.print("Introduce 1 para añadir un videojuego\n" +
                    "Introduce 2 para eliminar un videojuego\n" +
                    "Introduce 3 para ver el inventario\n" +
                    "Introduce 0 para salir\n" +
                    "---> ");
            option = scanner.nextLine();

            switch (option) {
                case "0":
                    System.out.println("Cerrando inventario");
                    break;
                case "1":
                    utilities.addVideogame(inventario);
                    break;
                case "2":
                    utilities.deleteVideogame(inventario);
                    break;
                case "3":
                    utilities.showInventory(inventario);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, inténtelo de nuevo.");
            }
        }
    }


}