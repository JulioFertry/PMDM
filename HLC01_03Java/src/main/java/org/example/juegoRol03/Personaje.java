package org.example.juegoRol03;

public abstract class Personaje {
    public abstract String getName();
    public abstract int getHealth();
    public abstract void setHealth(int health);
    public abstract int getDamage();

    public void receiveDamage(int damage) {
        System.out.println(getName() + " recibe " + damage + " de daño");
        setHealth(getHealth() - damage);
        if (!isAlive()) {
            die();
        }
    }

    public void attack(Personaje target) {
        System.out.println(getName() + " ataca con " + getDamage() + " de daño");
        target.receiveDamage(getDamage());
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    private void die() {
        System.out.println(getName() + " ha muerto!");
    }

}