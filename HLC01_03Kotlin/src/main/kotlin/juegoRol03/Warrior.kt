package org.example.juegoRol03

class Warrior(override val name: String = "Guerrero",
              override var health: Int = 100,
              override val damage: Int = 15
): Personaje()