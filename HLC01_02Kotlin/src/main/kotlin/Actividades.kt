import kotlin.random.Random

object Actividades {

    fun ej01() {
        print("Dime tu nombre: ")
        val name = readln()
        println("¡Hola, $name!")
    }


    fun ej02() {
        print("Dame un numero entero: ")
        val number = readln().toInt()

        if (number % 2 == 0) {
            println("Es par")
        } else {
            println("Es impar")
        }

    }


    fun ej03() {
        print("Dame un numero positivo: ")
        val radio = readln().toDouble()

        if (radio < 0) {
            throw NumberFormatException("Numero negativo")
        }

        val pi = 3.14159
        val area = pi * (radio * radio)
        println("El area de un circulo de radio $radio es de $area")
    }


    fun ej04() {
        val randomNumber = Random.nextInt(1, 101)
        var guessNumber = 0

        while (guessNumber != randomNumber) {
            print("Introduce un numero del 1 al 100: ")
            guessNumber = readln().toInt()

            if (guessNumber < randomNumber) {
                println("el número ingresado es MENOR que el número que buscas")
            } else if (guessNumber > randomNumber) {
                println("el número ingresado es MAYOR que el número que buscas")
            } else {
                println("¡Has acertado!")
            }

        }

    }


    fun ej05() {
        print("Dame un numero positivo: ")
        val number = readln().toInt()

        if (number < 0) {
            throw NumberFormatException("Numero negativo")
        }

        println("Tabla del $number")
        for (i in 1..10) {
            println("$number * $i = ${number * i}")
        }
    }


    fun ej06() {
        var sum = 0

        for (i in 1..100) {
            sum += i
        }

        println("sumatorio del 1 al 100 = $sum")
    }


    fun ej07() {
        print("Introduce una palabra/frase: ")
        val phrase = readln()
        var newPhrase = ""

        for (i in phrase.length -1 downTo 0) {
            newPhrase += phrase[i]
        }

        println(newPhrase)

    }


    fun ej08() {
        val vowels = "aeiou"
        var vowelCount = 0

        print("Introduce una palabra/frase: ")
        val phrase = readln().lowercase()

        for (i in phrase) {
            if (i in vowels) {
                vowelCount += 1
            }
        }

        println("Tu frase tiene $vowelCount vocales")
    }


    fun ej09() {
        var esPrimo = true

        print("Dame un numero entero: ")
        val number = readln().toInt()

        if (number <= 0) {
            throw NumberFormatException("Numero negativo o igual a 0")
        }

        if (number == 1) {
            esPrimo = false
        } else {
            for (i in 2 until number) {
                if (number % i == 0) {
                    esPrimo = false
                    break
                }
            }
        }

        if (esPrimo) {
            println("El $number es primo")
        } else {
            println("El $number no es primo")
        }
    }


    fun ej10() {
        print("Introduce la temperatura en celsius: ")
        val temp1 = readln().toDouble()
        val fah = temp1 * 9/5 + 32
        println("$temp1 grados Celsius son $fah grados Fahrenheit")

        print("Introduce la temperatura en fahrenheit: ")
        val temp2 = readln().toDouble()
        val cel = (temp2 - 32) * 5/9
        println("$temp2 grados Fahrenheit son $cel grados Celsius")
    }


    fun ej11() {
        print("Introduce un numero: ")
        val number = readln().toInt()
        if (number <= 0) {
            throw NumberFormatException("Numero negativo o igual a 0")
        }

        var oldNumber = 0
        var newNumber = 1

        if (number == 1) {
            println(oldNumber)
        } else {
            println(oldNumber)
            println(newNumber)
            for (i in 0 until number-2) {
                val currentNumber = newNumber
                newNumber += oldNumber
                oldNumber = currentNumber
                println(newNumber)
            }
        }

    }


    fun ej12() {
        print("Introduce un numero entero: ")
        val number = readln().toInt()
        var normalNumber = number
        var reversedNumber = 0

        if (number < 0) {
            throw NumberFormatException("Numero negativo o igual a 0")
        }

        while (normalNumber != 0) {
            val digit = normalNumber % 10
            reversedNumber = reversedNumber * 10 + digit
            normalNumber /= 10
        }

        println("$number ---> $reversedNumber")
    }


    fun ej13() {
        print("Introduce el nombre del anime: ")
        val nombre = readln()
        print("Introduce la cantidad de capitulos: ")
        val capitulos = readln().toInt()
        print("Introduce el genero del anime: ")
        val genero = readln()

        val anime = Anime(nombre, capitulos, genero)
        println(anime.toString())
    }


    fun ej14() {
        val inventario = mutableListOf<Videojuego>()
        val utilities = InventoryUtils()

        var option = "hola"

        while (option != "0") {
            print("Introduce 1 para añadir un videojuego\n" +
                    "Introduce 2 para eliminar un videojuego\n" +
                    "Introduce 3 para ver el invetario\n" +
                    "Introduce 0 para salir\n" +
                    "---> ")
            option = readln()

            when (option) {
                "0" -> println("Cerrando inventario")
                "1" -> utilities.addVideogame(inventario)
                "2" -> utilities.deleteVideogame(inventario)
                "3" -> utilities.showInventory(inventario)
            }
        }

    }

}