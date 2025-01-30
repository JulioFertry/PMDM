import 'dart:core';
import 'dart:io';
import 'dart:math';

class act2 {

  /** devuelve un numero aleatorio entre 1 y 100 */
  int _getRandomNumber() {
    Random random = Random();
    return random.nextInt(100) + 1;
  }


  /** Pide un numero al usuario y lo devuelve en caso de que sea válido */
  int _askForNumber() {
    int number = 0;

    print('Introduce un número: ');
    String? numberString = stdin.readLineSync();

    if (numberString != null) {
      number = int.parse(numberString);
    } else {
      throw Exception('El numero no puede ser nulo');
    }

    if (number <= 0) {
      throw Exception('El numero no puede ser 0 o menor');
    } else if (number > 100) {
      throw Exception('El numero no puede ser mayor que 100');
    }

    return number;
  }


  /** Ejecuta la actividad 2 */
  void playAct2() {
    try {
      print('Adivina el número entre el 1 y el 100');
      int guessNumber = 0;
      int magicNumber = _getRandomNumber();
      while (guessNumber != magicNumber) {
        guessNumber = _askForNumber();
        if (guessNumber < magicNumber) {
          print('$guessNumber es menor que el numero que estás buscando');
        } else if (guessNumber > magicNumber) {
          print('$guessNumber es mayor que el numero que estás buscando');
        } else {
          print('Correcto!');
        }
      }
    } catch (e) {
      print('***ERROR*** - $e');
    }
  }

}