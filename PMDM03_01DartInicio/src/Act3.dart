import 'dart:core';
import 'dart:io';

class act3 {

  var students = {};


  // Pide un input de un nombre al usuario y lo devuelve
  String? askForName() {
    print('Introduce un nombre: ');
    String? newName;
    newName = stdin.readLineSync();
    return newName;
  }


  // Pide un input de una nota al usuario y la devuelve
  int? askForGrade() {
    print('Introduce la nota: ');
    String? newGrade;
    newGrade = stdin.readLineSync();

    if (newGrade != null) {
      int? number = int.tryParse(newGrade);
      return number;
    } else {
      print('El numero introducido no es valido\n');
    }

    return 0;
  }


  // Agrega un estudiante con su nota al diccionario
  void addStudent() {
    String? name = askForName();
    int? grade = askForGrade();

    if (grade != null && name != null) {
      students[name] = grade;
      print('Estudiante agregado: $name con nota $grade\n');
    } else {
      print('No se pudo agregar el estudiante');
    }

  }


  // Muestra todos los estudiantes con sus notas
  void showStudents() {
    print('Estudiantes:\n');
    students.forEach((name, grade) {
      print('$name - $grade\n');
    });

  }


  // Muestra las opciones del menu
  void showMenu() {
    print('1 para ver todos los estudiantes\n'
        '2 para agregar un estudiante\n'
        '0 para salir\n');
  }


  void act3Main() {
    String? input = "";

    while (input != "0") {
      showMenu();
      print('---> ');
      input = stdin.readLineSync();

      switch (input) {
        case "1":
          showStudents();
          break;

        case "2":
          addStudent();
          break;

        case "0":
          print('Adios');
          break;
      }

    }

  }


}