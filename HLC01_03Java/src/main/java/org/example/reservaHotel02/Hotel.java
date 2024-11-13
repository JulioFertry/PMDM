package org.example.reservaHotel02;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final Console console;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Reservation> bookings = new ArrayList<>();

    private static final int FLOORS = 4;
    private static final int ROOMS_PER_FLOOR = 4;

    public Hotel(Console console) {
        this.console = console != null ? console : new Console();
        initializeRooms();
    }

    /** Añade todas las habitaciones del hotel a la lista de habitaciones */
    private void initializeRooms() {
        double actualRoomPrice = 50.0;
        for (int floor = 0; floor < FLOORS; floor++) {
            String floorNumber = String.valueOf(floor);
            actualRoomPrice += 50.0;

            for (int room = 1; room <= ROOMS_PER_FLOOR; room++) {
                String roomNumber = floorNumber + "0" + room;
                Room newRoom = new Room(roomNumber, actualRoomPrice);
                rooms.add(newRoom);
            }
        }
    }

    /** Muestra la información de las habitaciones que están disponibles */
    private void showAvailableRooms() {
        console.showMessage("Habitaciones disponibles: ", true);
        for (Room room : rooms) {
            if (!room.isBooked()) {
                console.showMessage(room.toString(), true);
            }
        }
    }

    /** Muestra la información de las reservas de un cliente o de todos los clientes */
    public void showBookings(String clientId) {
        if (clientId == null || clientId.isEmpty()) {
            for (Reservation reservation : bookings) {
                console.showMessage(reservation.toString(), true);
            }
        } else {
            for (Reservation reservation : bookings) {
                if (reservation.getClientId().equals(clientId)) {
                    console.showMessage(reservation.toString(), true);
                }
            }
        }
    }

    /** Introduce un cliente y lo retorna */
    private Client insertClient() throws Exception {
        console.showMessage("Introduce el nombre del cliente: ", false);
        String clientName = console.readString().trim();
        console.showMessage("Introduce el apellido del cliente: ", false);
        String clientSurname = console.readString().trim();

        if (clientName.isEmpty() && clientSurname.isEmpty()) {
            throw new Exception("Los datos del cliente son inválidos");
        }

        String clientId = (clientName + "000").substring(0, 3) + (clientSurname + "000").substring(0, 3);
        return new Client(clientName, clientSurname, clientId);
    }

    /** Introduce una habitación, la busca en el hotel y la retorna si existe y no está reservada */
    private Room searchAvailableRoom() throws Exception {
        console.showMessage("Introduce el número de la habitación: ", false);
        String roomId = console.readString();
        Room room = rooms.stream().filter(r -> r.getNumber().equals(roomId)).findFirst()
                .orElseThrow(() -> new Exception("La habitación no existe"));
        if (room.isBooked()) {
            throw new Exception("La habitación ya está reservada");
        }
        return room;
    }

    /** Reserva una habitación a un cliente */
    public void doReservation() {
        try {
            Client client = insertClient();
            showAvailableRooms();
            Room room = searchAvailableRoom();
            room.book();
            Reservation reservation = new Reservation(room, client);
            bookings.add(reservation);
            console.showMessage("Reserva completada con éxito", true);
        } catch (Exception e) {
            console.showMessage("ERROR al hacer la reserva: (" + e + ")", true);
        }
    }

    /** Comprueba si un cliente tiene reservas */
    private boolean clientHasBookings(String clientId) {
        return bookings.stream().anyMatch(reservation -> reservation.getClientId().equals(clientId));
    }

    /** Pide el ID de un cliente y lo devuelve si el cliente tiene una reserva */
    private String searchByClientId() {
        console.showMessage("Introduce el id del cliente: ", false);
        String clientId = console.readString();
        return clientHasBookings(clientId) ? clientId : null;
    }

    /** Pregunta al usuario si quiere eliminar todas las reservas de un cliente y retorna su decisión */
    private boolean doCompleteRemoval() {
        console.showMessage("Quieres eliminar todas las reservas del cliente? (y/n): ", false);
        String command = console.readString().toLowerCase();
        boolean result = false;

        switch (command) {
            case "y", "yes" -> {
                console.showMessage("Se eliminarán todas las reservas del cliente", true);
                result = true;
            }
            case "n", "no" -> console.showMessage("Borrado manual", true);
            default -> console.showMessage("Respuesta inválida, usa el borrado manual", true);
        }
        return result;
    }

    /** Pide al usuario el id de una habitación y la retorna si existe */
    private Room searchDeletableRooms() throws Exception {
        console.showMessage("Introduce el número de la habitación: ", false);
        String roomId = console.readString();
        Room room = rooms.stream().filter(r -> r.getNumber().equals(roomId)).findFirst()
                .orElseThrow(() -> new Exception("La habitación no existe"));
        if (!room.isBooked()) {
            throw new Exception("La habitación no tiene una reserva");
        }
        return room;
    }

    /** Elimina todas las reservas de un cliente */
    private void deleteAllFromClient(String clientId) {
        bookings.removeIf(reservation -> reservation.getClientId().equals(clientId));
        console.showMessage("Todas las reservas eliminadas con éxito", true);
    }

    /** Elimina una reserva */
    public void cancelReservation() {
        try {
            String clientId = searchByClientId();
            if (clientId != null && clientHasBookings(clientId)) {
                if (doCompleteRemoval()) {
                    deleteAllFromClient(clientId);
                } else {
                    showBookings(clientId);
                    Room room = searchDeletableRooms();
                    Reservation reservation = bookings.stream()
                            .filter(r -> r.getClientId().equals(clientId) && r.getRoomNumber().equals(room.getNumber()))
                            .findFirst()
                            .orElse(null);
                    if (reservation != null && bookings.remove(reservation)) {
                        console.showMessage("Reserva eliminada con éxito", true);
                        room.unBook();
                    } else {
                        console.showMessage("No se pudo eliminar la reserva", true);
                    }
                }
            } else {
                console.showMessage("El cliente introducido no tiene reservas", true);
                showBookings(null);
                Room room = searchDeletableRooms();
                Reservation reservation = bookings.stream()
                        .filter(r -> r.getRoomNumber().equals(room.getNumber()))
                        .findFirst()
                        .orElse(null);
                if (reservation != null && bookings.remove(reservation)) {
                    console.showMessage("Reserva eliminada con éxito", true);
                    room.unBook();
                } else {
                    console.showMessage("No se pudo eliminar la reserva", true);
                }
            }
        } catch (Exception e) {
            console.showMessage("ERROR al eliminar una reserva: (" + e + ")", true);
        }
    }

}