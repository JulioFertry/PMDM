package org.example.juegoRol03;

import java.util.Scanner;

public class FightMenu {
    private Warrior pj1 = new Warrior();
    private Mage pj2 = new Mage();

    private Scanner scanner = new Scanner(System.in);

    private String warriorOption() {
        System.out.println("Jugador 1 (Guerrero)");
        System.out.println("1 para atacar\n----> ");
        return scanner.nextLine();
    }

    private void performWarriorOption(String option) {
        switch (option) {
            case "1":
                pj1.attack(pj2);
                break;
            default:
                System.out.println("Has fallado el ataque");
                break;
        }
    }

    private String mageOption() {
        System.out.println("Jugador 2 (Mago)");
        System.out.println("1 para atacar\n2 para lanzar bola de fuego\n3 para lanzar hechizo de ludopatía\n----> ");
        return scanner.nextLine();
    }

    private void performMageOption(String option) {
        switch (option) {
            case "1":
                pj2.attack(pj1);
                break;
            case "2":
                pj2.castSpell(pj2.getFireball(), pj1);
                break;
            case "3":
                pj2.castSpell(pj2.getGamblingSpell(), pj1);
                break;
            default:
                System.out.println("Has fallado el ataque");
                break;
        }
    }

    public void fight() {
        while (pj1.isAlive() && pj2.isAlive()) {

            if (pj1.isAlive()) {
                String pj1Option = warriorOption();
                performWarriorOption(pj1Option);
            }

            if (pj2.isAlive()) {
                String pj2Option = mageOption();
                performMageOption(pj2Option);
            }
        }
    }

}