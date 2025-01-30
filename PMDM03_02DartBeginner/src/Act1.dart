import 'dart:core';
import 'dart:io';

class act1 {

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
    }

    return number;
  }


  /** Recibe un numero y devuelve una lista con todos sus divisores */
  List<int> _calculateDividers(number) {
    List<int> dividers = [];
    for (int i = number; i >= 1; i--) {
      if (number % i == 0) {
        dividers.add(i);
      }
    }
    return dividers;
  }


  /** Ejecuta la actividad 1 */
  void playAct1() {
    try {
      int number = _askForNumber();
      List<int> dividers = _calculateDividers(number);
      dividers.forEach(print);
    } catch (e) {
      print('***ERROR*** - $e');
    }
  }

}