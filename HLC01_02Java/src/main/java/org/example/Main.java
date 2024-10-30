package org.example;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        String option = "hola";

        try {
            while (!option.equals("0")) {
                option = menu.askForOption();
                menu.performOption(option);
            }
        } catch (Exception e) {
            System.out.println("*** ERROR *** - " + e.getMessage());
        }
    }

}