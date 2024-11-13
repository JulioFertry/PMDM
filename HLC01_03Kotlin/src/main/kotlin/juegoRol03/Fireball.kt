package org.example.juegoRol03

import kotlin.random.Random

class Fireball : Spell {
    override val name: String = "fuego"

    override fun cast(caster: Personaje, target: Personaje) {
        val damage = Random.nextInt(10, 21)
        target.receiveDamage(damage)
    }
}