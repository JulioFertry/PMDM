package org.example.reservaHotel02;

public class Client {
    private final String name;
    private final String surname;
    private final String id;


    public Client(String name, String surname, String id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}