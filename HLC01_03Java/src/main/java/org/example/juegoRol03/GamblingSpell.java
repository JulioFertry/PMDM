package org.example.juegoRol03;

import java.util.Random;

public class GamblingSpell implements Spell {
    private final String name = "ludopatía";

    public String getName() {
        return name;
    }

    private boolean isPair(int num) {
        return num % 2 == 0;
    }

    @Override
    public void cast(Personaje caster, Personaje target) {
        Random random = new Random();
        int outcome = random.nextInt(100) + 1; // Random between 1 and 100 (inclusive)

        if (isPair(outcome)) {
            System.out.println("Buena suerte");
            target.receiveDamage(999999999); // Apply massive damage
        } else {
            System.out.println("Mala suerte");
            caster.receiveDamage(999999999); // Apply massive damage
        }
    }

}