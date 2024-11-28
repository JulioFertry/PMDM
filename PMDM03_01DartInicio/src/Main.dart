import 'dart:io';

import 'Act1.dart';
import 'Act2.dart';
import 'Act3.dart';


// Muestra el menu inicial
void showMainMenu() {
  print('1 para Act1\n2 para Act 2\n 3 para Act 3\n0 para salir');
}


void main() {
  act1 actividad1 = act1();
  act2 actividad2 = act2();
  act3 actividad3 = act3();
  String? input = "";

  while (input != "0") {
    showMainMenu();
    print('---> ');
    input = stdin.readLineSync();

    switch (input) {
      case "1":
        actividad1.act1Main();
        break;

      case "2":
        actividad2.act2Main();
        break;

      case "3":
        actividad3.act3Main();
        break;

      case "0":
        print('Adios');
        break;
    }

  }

}