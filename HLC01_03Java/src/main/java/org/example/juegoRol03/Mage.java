package org.example.juegoRol03;

public class Mage extends Personaje {
    private final String name;
    private int health;
    private final int damage;
    private final Fireball fireball = new Fireball();
    private final GamblingSpell gamblingSpell = new GamblingSpell();


    public Mage(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }


    public Fireball getFireball() {
        return fireball;
    }


    public GamblingSpell getGamblingSpell() {
        return gamblingSpell;
    }


    public Mage() {
        this("Mago", 80, 3);
    }


    @Override
    public String getName() {
        return name;
    }


    @Override
    public int getHealth() {
        return health;
    }


    @Override
    public void setHealth(int health) {
        this.health = health;
    }


    @Override
    public int getDamage() {
        return damage;
    }


    public void castSpell(Spell spell, Personaje target) {
        System.out.println(name + " lanza un hechizo de " + spell.getName());
        spell.cast(this, target);
    }

}