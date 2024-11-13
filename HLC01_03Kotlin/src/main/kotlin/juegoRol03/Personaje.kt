package org.example.juegoRol03

abstract class Personaje {
    abstract val name: String
    abstract var health: Int
    abstract val damage: Int


    fun receiveDamage(damage: Int) {
        println("$name recibe $damage de daño")
        this.health -= damage
        if (!isAlive()) {
            die()
        }
    }


    fun attack(target: Personaje) {
        println("$name ataca con $damage de daño")
        target.receiveDamage(this.damage)
    }


    fun isAlive(): Boolean {
        return this.health > 0
    }


    private fun die() {
        println("$name ha muerto!")
    }

}