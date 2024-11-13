package org.example.juegoRol03

import kotlin.random.Random

class GamblingSpell : Spell {
    override val name: String = "ludopatía"


    private fun isPair(num: Int): Boolean {
        return num % 2 == 0
    }


    override fun cast(caster: Personaje, target: Personaje) {
        val outcome = Random.nextInt(1, 101)
        if (isPair(outcome)) {
            println("Buena suerte")
            target.receiveDamage(9999999)
        } else {
            println("Mala suerte")
            caster.receiveDamage(9999999)
        }
    }

}