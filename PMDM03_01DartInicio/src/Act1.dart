import 'dart:io';

class act1 {

  Set<String> favoriteGenres = Set<String>();


  //Valida que la cantidad de elementos en la lista no sea mayor o igual a 5
  bool validateAmount() {
    if (favoriteGenres.length >= 5) {
      return false;
    } else {
      return true;
    }
  }


  // Añade un nuevo genero a la lista si no está repetido o hay mas de 5 elementos
  void addGenero(String? newGenre) {
    if (validateAmount() && newGenre != null) {
      if (favoriteGenres.add(newGenre)) {
        print('Agregado $newGenre a tu lista\n');
      } else {
        print('No se ha agregado $newGenre porque ya existe\n');
      }

    } else {
      print('No puedes tener más de 5 géneros favoritos\n');
    }
  }


  // Pide un input de un genero al usuario y lo devuelve
  String? askForGenre() {
    print('Introduce un genero: ');
    String? newGenre;
    newGenre = stdin.readLineSync();
    return newGenre;
  }


  // Muestra la lista de generos actual
  void showGenres() {
    print('Tu lista actual de generos favoritos:\n');
    for (String genre in favoriteGenres) {
      print(genre + "\n");
    }
  }


  void mainUse() {
    showGenres();
    String? newGenre = askForGenre();
    addGenero(newGenre);
    showGenres();
  }

}