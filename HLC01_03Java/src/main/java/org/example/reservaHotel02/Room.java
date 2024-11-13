package org.example.reservaHotel02;

public class Room {
    private final String number;
    private final double price;
    private boolean booked;


    public Room(String number, double price) {
        this.number = number;
        this.price = price;
        this.booked = false;
    }


    public String getNumber() {
        return number;
    }


    public double getPrice() {
        return price;
    }


    public boolean isBooked() {
        return booked;
    }


    public void book() {
        this.booked = true;
    }


    public void unBook() {
        this.booked = false;
    }


    @Override
    public String toString() {
        return "Habitación: " + number + " - Precio: " + price + " - Estado: " + (booked ? "Reservada" : "Libre");
    }
}
