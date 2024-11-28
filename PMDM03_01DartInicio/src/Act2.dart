import 'dart:io';

class act2 {

  List<String> tasks = [];

  // Añade una tarea a la lista si no es null o vacío
  void addTask(String? newTask) {
    if (newTask != null && newTask.isNotEmpty) {
      tasks.add(newTask);
    } else {
      print('No se pudo agregar la tarea\n');
    }

  }


  // Pide un input de una tarea al usuario y la devuelve
  String? askForTask() {
    print('Introduce una tarea: ');
    String? newTask;
    newTask = stdin.readLineSync();
    return newTask;
  }


  // Muestra todas las tareas
  void showTasks() {
    print('Tus tareas: ');
    for (var task in tasks.reversed) {
      print(task + "\n");
    }

  }


  // Muestra las opciones del menu
  void showMenu() {
    print('1 para ver todas las tareas\n'
        '2 para agregar una tarea\n'
        '0para salir\n');
  }


  void actMain() {
    String? input = "";

    while (input != "0") {
      showMenu();
      print('---> ');
      input = stdin.readLineSync();

      switch (input) {
        case "1":
          showTasks();
          break;

        case "2":
          String? newTask = askForTask();
          addTask(newTask);
          break;

        case "0":
          print('Adios');
          break;
      }

    }

  }


}