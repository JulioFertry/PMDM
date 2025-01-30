import 'dart:core';
import 'dart:io';

class act1 {

  /** Pide un numero al usuario y lo devuelve en caso de que sea válido */
  int? askForNumber() {
    int number = 0;

    print('Introduce un número: ');
    String? numberString = stdin.readLineSync();

    if (numberString != null) {
      number = int.parse(numberString);
    } else {
      throw Exception("El numero no puede ser nulo");
    }

    return number;
  }

  int? calculateDividers(int) {
    
  }

}