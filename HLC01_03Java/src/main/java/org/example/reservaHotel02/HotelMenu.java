package org.example.reservaHotel02;

public class HotelMenu {
    private final Console console;
    private final Hotel hotel;

    public HotelMenu() {
        this.console = new Console();
        this.hotel = new Hotel(console);
    }

    private String askForOption() {
        console.showMessage("1 para hacer una reserva\n" +
                "2 para cancelar una reserva\n" +
                "3 para ver todas las reservas\n" +
                "0 para salir\n" +
                "---------> ", true);
        String option = console.readString();  // Utilizamos readString en lugar de readln
        console.showMessage("", true);
        return option;
    }

    private void performOption(String option) {
        switch (option) {
            case "0":
                System.out.println("Adios");
                break;
            case "1":
                hotel.doReservation();
                break;
            case "2":
                hotel.cancelReservation();
                break;
            case "3":
                hotel.showBookings(null);
                break;
            default:
                console.showMessage("La opción introducida no existe...", true);
                break;
        }
    }

    public void executeMenu() {
        String option = "hola";
        try {
            while (!option.equals("0")) {
                option = askForOption();
                performOption(option);
            }
        } catch (Exception e) {
            System.out.println("*** ERROR *** - " + e);
        }
    }

}