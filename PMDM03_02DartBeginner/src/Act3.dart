import 'dart:core';
import 'dart:io';
import 'dart:math';

class act3{

  /** Recibe un string y decide si es valido o no */
  bool _validateEmail(String email) {
    RegExp regex = RegExp(r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$');
    return regex.hasMatch(email);
  }


  /** Pide al usuario un email y lo devuelve */
  String _insertEmail() {
    print('Introduce un email: ');
    String? email = stdin.readLineSync();
    if (email == null) {
      throw Exception('El numero no puede ser nulo');
    }
    return email;
  }


  /** Ejecuta la actividad 3 */
  void playAct3() {
    try {
      String email = _insertEmail();
      if (_validateEmail(email)) {
        print('$email es un email válido');
      } else {
        print('Error, $email no es válido');
      }
    } catch (e) {
      print('***ERROR*** - $e');
    }
  }

}