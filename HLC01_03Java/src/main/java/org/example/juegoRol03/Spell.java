package org.example.juegoRol03;


public interface Spell {
    String getName();

    void cast(Personaje caster, Personaje target);
}