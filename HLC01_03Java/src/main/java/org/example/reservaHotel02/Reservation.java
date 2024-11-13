package org.example.reservaHotel02;

public class Reservation {
    private final Room room;
    private final Client client;
    private final String clientId;
    private final String roomNumber;


    public Reservation(Room room, Client client) {
        this.room = room;
        this.client = client;
        this.clientId = client.getId();
        this.roomNumber = room.getNumber();
    }


    public String getClientId() {
        return clientId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }


    @Override
    public String toString() {
        return "Habitación: " + roomNumber + " - Cliente: " + client.getName() + " " + client.getSurname();
    }

}