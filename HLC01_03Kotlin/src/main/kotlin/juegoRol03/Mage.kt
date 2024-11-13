package org.example.juegoRol03

class Mage(override val name: String = "Mago",
              override var health: Int = 80,
              override val damage: Int = 3
): Personaje() {
    val fireball = Fireball()
    val gamblingSpell = GamblingSpell()

    fun castSpell(spell: Spell, target: Personaje) {
        println("$name lanza un hechizo de ${spell.name}")
        spell.cast(this, target)
    }

}