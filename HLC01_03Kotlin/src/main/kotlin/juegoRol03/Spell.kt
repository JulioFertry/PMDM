package org.example.juegoRol03

interface Spell {
    val name: String

    fun cast(caster: Personaje, target: Personaje)
}