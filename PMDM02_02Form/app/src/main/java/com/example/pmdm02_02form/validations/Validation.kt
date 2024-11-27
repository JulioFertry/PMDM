package com.example.pmdm02_02form.validations

import androidx.core.text.isDigitsOnly

class Validation {

    private fun validateName(name: String): Pair<String, Boolean> {

        val result: Pair<String, Boolean> = if (name.isEmpty()) {
            Pair("El nombre no puede estar vacío", false)
        } else if (name.isBlank()) {
            Pair("Tienes que tener un nombre que no sea todo espacios", false)
        } else if (name.length > 30) {
            Pair("No me creo que tu nombre tenga mas de 30 caracteres", false)
        } else {
            Pair("Pedazo de nombre tienes", true)
        }

        return result
    }


    private fun validateDNI(dni: String): Pair<String, Boolean> {
        val result: Pair<String, Boolean>

        if (dni.isEmpty()) {
            result = Pair("El DNI no puede estar vacío", false)
        } else if (dni.length != 9) {
            result = Pair("El DNI debe tener 9 caracteres", false)
        } else if (dni.contains(" ")) {
            result = Pair("Tu DNI no puede tener espacios", false)
        } else {

            val dniNumbers = dni.substring(0, 8)
            val dniLetter = dni.last()

            result = if (!dniNumbers.all { it.isDigit() }) {
                Pair("Tu dni no es correcto", false)
            } else if (!dniLetter.isLetter()) {
                Pair("Tu dni no es correcto", false)
            } else {
                Pair("Ya me sé tu dni", true)
            }

        }

        return result
    }



    private fun validateAge(age: String): Pair<String, Boolean> {

        val result: Pair<String, Boolean> = if (age.isEmpty()) {
            Pair("La edad no puede estar vacía", false)
        } else if (age.isBlank()) {
            Pair("La edad no puede estar vacía", false)
        } else if (!age.isDigitsOnly()) {
            Pair("Tu edad debe ser un numero", false)
        } else if (age.toInt() < 18) {
            Pair("Los menores no pueden entrar aquí", false)
        } else if (age.toInt() > 120) {
            Pair("Eres demasiado viejo para el internet", false)
        } else {
            Pair("a", true)
        }


        return result
    }


    fun validation(name: String, dni: String, age: String): List<Pair<String, Boolean>> {
        val nameValidation = validateName(name)
        val dniValidation = validateDNI(dni)
        val ageValidation = validateAge(age)

        return listOf(nameValidation, dniValidation, ageValidation)
    }

}