package org.example.reservaHotel02;

import java.util.Scanner;

public class Console {
    private final Scanner scanner = new Scanner(System.in);

    public void showMessage(String message, boolean jumpLine) {
        if (jumpLine) {
            System.out.println(message);
        } else {
            System.out.print(message);
        }
    }

    public String readString() {
        return scanner.nextLine();
    }

}