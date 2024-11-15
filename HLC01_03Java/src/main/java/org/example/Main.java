package org.example;

import org.example.gestionBiblioteca01.LibraryOperations;
import org.example.gestionEstudiantes04.SchoolMenu;
import org.example.gestorTareas05.TaskMenu;
import org.example.juegoRol03.FightMenu;
import org.example.reservaHotel02.HotelMenu;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        LibraryOperations library = new LibraryOperations();
        HotelMenu hotel = new HotelMenu();
        FightMenu rpg = new FightMenu();
        SchoolMenu school = new SchoolMenu();
        TaskMenu task = new TaskMenu();

        Scanner scanner = new Scanner(System.in);

        String option = "";


        try {
            while (!option.equals("0")) {
                option = askForOption(scanner);
                performOption(option, library, hotel, rpg, school, task);
            }

        } catch (Exception e) {
            System.out.println("*** ERROR *** - " + e);
        }
    }


    public static String askForOption(Scanner scanner) {
        System.out.println("1 act1");
        System.out.println("2 act2");
        System.out.println("3 act3");
        System.out.println("4 act4");
        System.out.println("5 act5");
        System.out.print("----> ");
        return scanner.nextLine();
    }


    public static void performOption(
            String option,
            LibraryOperations library,
            HotelMenu hotel,
            FightMenu rpg,
            SchoolMenu school,
            TaskMenu task
    ) {
        switch (option) {
            case "0":
                System.out.println("Adios");
                break;
            case "1":
                library.appMenu();
                break;
            case "2":
                hotel.executeMenu();
                break;
            case "3":
                rpg.fight();
                break;
            case "4":
                school.executeMenu();
                break;
            case "5":
                task.executeMenu();
                break;
            default:
                System.out.println("La opción introducida no existe...");
                break;
        }
    }

}