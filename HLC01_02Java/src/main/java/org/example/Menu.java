package org.example;

import java.util.*;


public class Menu {
    private Actividades actividades = new Actividades();
    private Scanner scanner = new Scanner(System.in);


    public String askForOption() {
        System.out.print("\nIntroduce el numero de la actividad (1-14) o 0 para salir: ");
        String option = scanner.nextLine();
        System.out.print("\n");
        return option;
    }


    public void performOption(String option) {
        switch (option) {
            case "0":
                System.out.println("Adios");
                break;
            case "1":
                actividades.ej01();
                break;
            case "2":
                actividades.ej02();
                break;
            case "3":
                actividades.ej03();
                break;
            case "4":
                actividades.ej04();
                break;
            case "5":
                actividades.ej05();
                break;
            case "6":
                actividades.ej06();
                break;
            case "7":
                actividades.ej07();
                break;
            case "8":
                actividades.ej08();
                break;
            case "9":
                actividades.ej09();
                break;
            case "10":
                actividades.ej10();
                break;
            case "11":
                actividades.ej11();
                break;
            case "12":
                actividades.ej12();
                break;
            case "13":
                actividades.ej13();
                break;
            case "14":
                actividades.ej14();
                break;
            default:
                System.out.println("La opción introducida no existe...");
                break;
        }
    }
}