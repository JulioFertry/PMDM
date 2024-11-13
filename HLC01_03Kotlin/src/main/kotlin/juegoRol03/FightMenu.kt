package org.example.juegoRol03


class FightMenu {
    private val pj1 = Warrior()
    private val pj2 = Mage()


    private fun warriorOption(): String {
        println("Jugado 1 (Guerrero)")
        println("1 para atacar\n----> ")
        val option = readln()
        return option
    }


    private fun performWarriorOption(option: String) {
        when (option) {
            "1" -> pj1.attack(pj2)
            else -> println("Has fallado el ataque")
        }
    }


    private fun mageOption(): String {
        println("Jugador 2 (Mago)")
        println("1 para atacar\n2 para lanzar bola de fuego\n3 para lanzar hechizo de ludopatía\n----> ")
        val option = readln()
        return option
    }


    private fun performMageOption(option: String) {
        when (option) {
            "1" -> pj2.attack(pj1)
            "2" -> pj2.castSpell(pj2.fireball, pj1)
            "3" -> pj2.castSpell(pj2.gamblingSpell, pj1)
            else -> println("Has fallado el ataque")
        }
    }


    fun fight() {
        while (pj1.isAlive() && pj2.isAlive()) {

            if (pj1.isAlive()) {
                val pj1Option = warriorOption()
                performWarriorOption(pj1Option)
            }

            if (pj2.isAlive()) {
                val pj1Option = mageOption()
                performMageOption(pj1Option)
            }

        }
    }

}