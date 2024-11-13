package org.example.juegoRol03;

import java.util.Random;

public class Fireball implements Spell {
    private final String name = "fuego";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void cast(Personaje caster, Personaje target) {
        Random random = new Random();
        int damage = random.nextInt(10, 21); // Random between 10 (inclusive) and 21 (exclusive)
        target.receiveDamage(damage);
    }

}